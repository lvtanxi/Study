package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Date: 2017-03-16
 * Time: 10:18
 * Description:
 */
public interface SeckillDao {
    /**
     * 减库存
     */
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    /**
     * 根据Id查询
     */
    Seckill queryById(long seckillId);

    /**
     *分页查询
     * 多个形参用@Param
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit")int limit);
    /**
     * 利用存储过程，减库存
     */
    void killByProcedure(Map<String,Object> paramMap);
}
