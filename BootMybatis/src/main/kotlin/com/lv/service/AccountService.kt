package com.lv.service

/**
 * Date: 2017-03-23
 * Time: 09:14
 * Description: 转账service
 */
interface AccountService {

    /**
     * 转账方法
     */
    fun transfer(outUser: String, inUser: String, money: Double):Int
}