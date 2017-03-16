package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccesKilled;

/**
 * Date: 2017-03-16
 * Time: 10:18
 * Description:
 */
public interface SuccesKilledDao {
    /**
     * 插入购买需求，可过滤重复
     *  @return 如果影响行数>1，表示更新的记录行数
     */
    int inserSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone") long userPhone);

    /**
     * 根据seckillId 查询SuccesKilled,并携带秒杀产品对象
     */
    SuccesKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);

}
