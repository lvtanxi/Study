package org.seckill.service.imp;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccesKilledDao;
import org.seckill.dto.Export;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccesKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * Date: 2017-03-16
 * Time: 15:49
 * Description:
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Resource
    private SeckillDao mSeckillDao;
    @Resource
    private SuccesKilledDao mSuccesKilledDao;

    private Logger mLogger = LoggerFactory.getLogger(getClass());
    //MD5
    private static final String slat = "asdfasdfdfhjrwrsdf13fg'jasopdjifpoiasdfo";

    @Cacheable(value = "getSeckillList")
    public List<Seckill> getSeckillList() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        return mSeckillDao.queryAll(0, 5);
    }

    public Seckill getById(long seckillId) {
        return mSeckillDao.queryById(seckillId);
    }

    public Export exportSeckilUrl(long seckillId) {
        Seckill seckill = mSeckillDao.queryById(seckillId);
        if (seckill == null)
            return new Export(false, seckillId);
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime())
            return new Export(false, nowTime.getTime(), startTime.getTime(), endTime.getTime(), seckillId);
        //转化特定字符串的过程，不可逆
        String md5 = getMd5(seckillId);
        return new Export(true, md5, seckillId);
    }

    /**
     * 使用注解控制事务优点：
     * 1：开发团队达成一致约定，明确标注事务方法的变成风格
     * 2：保证事务方法的执行时间尽可能的短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3：不是所有的方法都需要事务。如只有一条修改操作，只读操作不需要事务控制
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws RepeatKillException, SeckillCloseException, SeckillException {
        if (md5 == null || !md5.equals(getMd5(seckillId)))
            throw new SeckillException("seckill data rewrite");
        try {
            //执行秒杀业务逻辑，
            Date date = new Date();
            int updateCount = mSeckillDao.reduceNumber(seckillId, date);
            if (updateCount <= 0) {
                //没有更新记录，秒杀结束
                throw new SeckillCloseException("seckill is closed");
            } else {
                //记录购买记录
                int insertCount = mSuccesKilledDao.inserSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {//重复秒杀
                    throw new RepeatKillException("seckill repeated");
                } else {
                    SuccesKilled succesKilled = mSuccesKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, succesKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (SeckillException e) {
            mLogger.error(e.getMessage(), e);
            //异常传化
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }

    private String getMd5(long seckillId) {
        String base = seckillId + "/" + slat;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
