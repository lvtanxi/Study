package com.lv.mapper

import com.lv.model.TsCenter

/**
 * Date: 2017-04-06
 * Time: 16:43
 * Description:
 */
interface TsCenterMapper {
    fun findAllMessage(param:Map<String,Any>):List<TsCenter>
}