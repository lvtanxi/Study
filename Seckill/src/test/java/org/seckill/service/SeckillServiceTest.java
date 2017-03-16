package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Export;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Date: 2017-03-16
 * Time: 17:04
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger mLogger= LoggerFactory.getLogger(getClass());
    @Autowired
    private SeckillService mSeckillService;
    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckillList = mSeckillService.getSeckillList();
        mLogger.info("list={}",seckillList);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = mSeckillService.getById(1000);
        mLogger.info("Seckill={}",seckill);
    }

    @Test
    public void exportSeckilUrl() throws Exception {
        Export export = mSeckillService.exportSeckilUrl(1000);
        mLogger.info("export={}",export);
        //export=Export{exposed=true, md5='a9504693ee3ba377c60b66eeb7893b49', seckillId=1000, now=0, start=0, end=0}
    }

    @Test
    public void executeSeckill() throws Exception {
        try {
            SeckillExecution seckillExecution = mSeckillService.executeSeckill(1000, 15202842965L, "a9504693ee3ba377c60b66eeb7893b49");
            mLogger.info("seckillExecution={}",seckillExecution);
        } catch (SeckillException e) {
            mLogger.error("export={}",e);
        }
    }

    @Test
    public void test()throws Exception {
        Export export = mSeckillService.exportSeckilUrl(1000);
        if(null!=export&&export.isExposed()){
            try {
                SeckillExecution seckillExecution = mSeckillService.executeSeckill(1000, 15202842975L,export.getMd5());
                mLogger.info("seckillExecution={}",seckillExecution);
            } catch (SeckillException e) {
                mLogger.error("export={}",e);
            }
        }else {
            mLogger.warn("export={}","秒殺未開啓");
        }
    }

}