package com.lv.controller

import com.lv.dto.ResultDto
import com.lv.service.TsCenterService
import com.lv.util.ResultUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

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
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        val checkKookie = checkKookie(request)
        println("$checkKookie >>>>>>>>>>>>>>>>>>>>>>>>>>")
        return ResultUtil.success(findAllUser)
    }

    fun checkKookie(request: HttpServletRequest): Boolean {
        request.cookies.forEach {
            if (it.name == "ssocookie" && it.value == "ss0")
                return true
        }
        return false
    }


}