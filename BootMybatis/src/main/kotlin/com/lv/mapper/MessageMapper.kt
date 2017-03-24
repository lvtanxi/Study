package com.lv.mapper

import com.lv.model.Message
import org.apache.ibatis.annotations.Param

/**
 * Date: 2017-03-23
 * Time: 15:09
 * Description:
 */
interface MessageMapper {
    fun findAll(@Param("command") command: String?, @Param("description") description: String?): List<Message>
}