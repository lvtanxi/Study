package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccesKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Date: 2017-03-16
 * Time: 15:04
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccesKilledDaoTest {
    @Resource
    private SuccesKilledDao mSuccesKilledDao;
    @Test
    public void inserSuccessKilled() throws Exception {
        int successKilled = mSuccesKilledDao.inserSuccessKilled(1000, 15202842963L);
        System.out.println(successKilled);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccesKilled succesKilled = mSuccesKilledDao.queryByIdWithSeckill(1000, 15202842963L);
        System.out.println(succesKilled);
    }

}