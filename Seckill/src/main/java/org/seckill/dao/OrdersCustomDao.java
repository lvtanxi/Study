package org.seckill.dao;

import org.seckill.dto.OrdersCustom;
import org.seckill.entity.OrderDetail;
import org.seckill.entity.Orders;

import java.util.List;

/**
 * Date: 2017-03-27
 * Time: 16:43
 * Description:
 */
public interface OrdersCustomDao {
    List<OrdersCustom> findOrdersUser();

    /** 查询订单关联查询用户信息，使用reslutMap实现*/
    List<Orders>findOrdersUserResultMap();

    /**查询订单（关联用户）以及订单明细*/
    List<OrderDetail>findOrdersAndOrderDetailResultMap();
}
