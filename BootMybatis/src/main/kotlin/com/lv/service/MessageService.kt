package com.lv.service

import com.lv.model.Message

/**
 * Date: 2017-03-23
 * Time: 15:12
 * Description:
 */
interface MessageService {
    fun findAll(command:String?, description:String?,pageNo:Int=1):List<Message>

    fun deleteOne( id: Any?):Int

    fun deleteBatch(ids:List<Int>):Int
}