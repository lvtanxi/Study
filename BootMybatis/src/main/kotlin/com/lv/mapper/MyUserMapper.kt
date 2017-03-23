package com.lv.mapper

import com.lv.model.MyUser

/**
 * Date: 2017-03-21
 * Time: 10:29
 * Description:
 */
interface MyUserMapper {
    fun findAllUser(): List<MyUser>

    fun addUser(mParam: Map<String,Any>):Int
}