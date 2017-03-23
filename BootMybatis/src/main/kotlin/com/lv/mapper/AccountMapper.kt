package com.lv.mapper

import org.apache.ibatis.annotations.Param

/**
 * Date: 2017-03-22
 * Time: 17:24
 * Description: 转账Dao
 */
interface AccountMapper {
    /**
     * 给某个用户减钱
     */
    fun outMovney(@Param("outUser")outUser:String,@Param("money")money:Double):Int

    /**
     * 给某个用户价钱
     */
    fun inMovney(@Param("inUser")inUser:String,@Param("money")money:Double):Int
}