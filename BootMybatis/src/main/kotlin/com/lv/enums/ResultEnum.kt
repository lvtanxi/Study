package com.lv.enums

/**
 * Date: 2017-03-21
 * Time: 17:19
 * Description:
 */
enum class ResultEnum(val code:Int,val msg:String) {
    UNKONW(-1,"未知错误"),
    SUCCESS(200,"操作成功"),
    EMPTY(100,"不能为空"),
    SHORT(101,"长度不够"),


}