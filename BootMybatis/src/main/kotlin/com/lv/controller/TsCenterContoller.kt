package com.lv.controller

import com.lv.dto.ResultDto
import com.lv.service.TsCenterService
import com.lv.util.ResultUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Date: 2017-04-06
 * Time: 17:01
 * Description:
 */
@RestController
@RequestMapping(value = "tsCenter")
class TsCenterContoller(val mTsCenterService: TsCenterService) {

    @GetMapping(value = "findAllMessage")
    fun findAllMessage(): ResultDto {
        val findAllUser = mTsCenterService.findAllMessage()
        return ResultUtil.success(findAllUser)
    }

}