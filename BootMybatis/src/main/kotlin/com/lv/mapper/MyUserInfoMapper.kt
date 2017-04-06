package com.lv.mapper

import com.lv.model.MyUserInfo

/**
 * Date: 2017-04-06
 * Time: 15:45
 * Description:
 */
interface MyUserInfoMapper {
    fun findAllMyUserInfo():List<MyUserInfo>

    fun findAllMyUserInfoMap():List<MyUserInfo>
}