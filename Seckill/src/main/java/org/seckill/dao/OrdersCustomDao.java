package org.seckill.dao;

import org.seckill.dto.OrdersCustom;

import java.util.List;

/**
 * Date: 2017-03-27
 * Time: 16:43
 * Description:
 */
public interface OrdersCustomDao {
    List<OrdersCustom> findOrdersUser();
}
