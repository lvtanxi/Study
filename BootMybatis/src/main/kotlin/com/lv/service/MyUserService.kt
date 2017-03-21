package com.lv.service

import com.lv.model.MyUser

/**
 * Date: 2017-03-21
 * Time: 10:53
 * Description:
 */
interface MyUserService {

    fun findAllUser():List<MyUser>

    fun addUser(mParam: Map<String,Any>):Int

    @Throws(Exception::class)
    fun verifyUser (mParam: Map<String,Any>)
}