package com.lv.controller

import com.lv.dto.ResultDto
import com.lv.service.MyUserService
import com.lv.util.ResultUtil
import org.springframework.web.bind.annotation.*

/**
 * Date: 2017-03-21
 * Time: 10:43
 * Description:
 */
@RestController
@RequestMapping(value = "user")
class MyUserController(val myUserService: MyUserService) {
    @GetMapping(value = "findAllUser")
    fun findAllUser(): ResultDto {
        val findAllUser = myUserService.findAllUser()
        return ResultUtil.success(findAllUser)
    }

    @PostMapping(value = "addUser")
    fun addUser(@RequestBody mParam: Map<String, Any>): Int {
        val res = ResultDto(1)
        return myUserService.addUser(mParam)
    }

    @PostMapping(value = "verifyUser")
    fun verifyUser(@RequestBody mParam: Map<String, Any>): ResultDto {
        myUserService.verifyUser(mParam)
        return ResultUtil.success("ASDF")
    }


}