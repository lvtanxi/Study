package com.lv.exception

import com.lv.enums.ResultEnum

/**
 * Date: 2017-03-21
 * Time: 16:23
 * Description:自定义Exception
 */
class ErrorException constructor(res: ResultEnum) : RuntimeException(res.msg){
    val code:Int = res.code
}