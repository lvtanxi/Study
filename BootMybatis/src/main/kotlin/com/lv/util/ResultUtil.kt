package com.lv.util

import com.lv.dto.ResultDto
import com.lv.enums.ResultEnum

/**
 * Date: 2017-03-21
 * Time: 15:35
 * Description:
 */
object ResultUtil {

    fun success(any: Any? = null): ResultDto {
        return ResultDto(any, msg = "操作成功")
    }

    fun error(msssage: String? = "", errorCode: Int = 0): ResultDto {
        return ResultDto(msg = msssage, code = errorCode)
    }

    fun error(resultEnum:ResultEnum):ResultDto {
        return ResultDto(msg = resultEnum.msg, code = resultEnum.code)
    }
}