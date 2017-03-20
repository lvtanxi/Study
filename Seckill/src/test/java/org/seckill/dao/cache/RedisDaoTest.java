package org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Date: 2017-03-20
 * Time: 10:42
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {
    @Resource
    private RedisDao mRedisDao;
    @Resource
    private SeckillDao mSeckillDao;

    @Test
    public void testSeckill() throws Exception {
        long id = 1001;
        Seckill seckill = mRedisDao.getSeckill(id);
        if(seckill==null) {
            seckill = mSeckillDao.queryById(id);
            if(seckill!=null){
                boolean putSeckill = mRedisDao.putSeckill(seckill);
                System.out.println(putSeckill);
                seckill= mRedisDao.getSeckill(id);
                System.out.println(seckill);
            }

        }

    }


}