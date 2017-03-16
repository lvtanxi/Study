package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * Date: 2017-03-16
 * Time: 12:53
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现
    @Resource
    private SeckillDao mSeckillDao;
    @Test
    public void reduceNumber() throws Exception {
        int reduceNumber = mSeckillDao.reduceNumber(1000, new Date());
        System.out.println(reduceNumber);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = mSeckillDao.queryById(1000);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = mSeckillDao.queryAll(0, 100);
        System.out.println(seckills.size());
    }

}