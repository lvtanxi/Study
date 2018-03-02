package com.lv.handle

import com.lv.dto.ResultDto
import com.lv.enums.ResultEnum
import com.lv.exception.ErrorException
import com.lv.util.ResultUtil
import com.lv.util.logger
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Date: 2017-03-21
 * Time: 16:18
 * Description: 异常同意处理
 */
@ControllerAdvice
class ExceptionHandle {

    @ExceptionHandler(value = [(Exception::class)])
    @ResponseBody
    fun handle(e:Exception):ResultDto{
            if (e is ErrorException)
                return ResultUtil.error(e.message,e.code)
        logger.info("[系统异常] {}",e)
        return ResultUtil.error(ResultEnum.UNKONW)
    }
}