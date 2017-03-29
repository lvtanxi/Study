package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.OrderDetail;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

/**
 * Date: 2017-03-27
 * Time: 16:53
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrdersCustomDaoTest {
    @Resource
    private OrdersCustomDao mOrdersCustomDao;
    @Test
    public void testFindOrdersAndOrderDetailResultMap() {
        // 调用mapper的方法
        List<OrderDetail> list = mOrdersCustomDao.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
    }

}