package com.lv.mapper

import com.lv.model.MyUser
import org.springframework.stereotype.Component

/**
 * Date: 2017-03-21
 * Time: 10:29
 * Description:
 */
@Component
interface MyUserMapper {
    fun findAllUser(): List<MyUser>

    fun addUser(mParam: Map<String,Any>):Int
}