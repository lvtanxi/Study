package com.lv.controller

import com.lv.dto.ResultDto
import com.lv.service.MyUserInfoService
import com.lv.util.ResultUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Date: 2017-03-21
 * Time: 10:43
 * Description:
 */
@RestController
@RequestMapping(value = "userInfo")
class MyUserInfoController(val myUserInfoService: MyUserInfoService) {
    @GetMapping(value = "findAllUserInfo")
    fun findAllUser(): ResultDto {
        val findAllUser = myUserInfoService.findAllMyUserInfo()
        return ResultUtil.success(findAllUser)
    }

    @GetMapping(value = "findAllMyUserInfoMap")
    fun findAllMyUserInfoMap(): ResultDto {
        val findAllUser = myUserInfoService.findAllMyUserInfoMap()
        return ResultUtil.success(findAllUser)
    }



}