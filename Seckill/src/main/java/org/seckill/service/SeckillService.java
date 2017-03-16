package org.seckill.service;

import org.seckill.dto.Export;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * Date: 2017-03-16
 * Time: 15:28
 * Description:业务接口：站在"使用者"角度设计接口
 * 三个方面：
 * 1.方法定义粒度
 * 2.参数
 * 3.返回类型
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时，输出秒杀接口地址，否者输出系统时间和秒杀时间
     */
    Export exportSeckilUrl(long seckillId);

    /**
     * 执行秒杀操作
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws RepeatKillException,SeckillCloseException,SeckillException;

}
