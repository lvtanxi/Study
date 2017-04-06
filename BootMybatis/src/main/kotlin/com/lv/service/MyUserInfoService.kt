package com.lv.service

import com.lv.model.MyUserInfo

/**
 * Date: 2017-04-06
 * Time: 15:48
 * Description:
 */
interface MyUserInfoService {
    fun findAllMyUserInfo():List<MyUserInfo>
    fun findAllMyUserInfoMap():List<MyUserInfo>
}