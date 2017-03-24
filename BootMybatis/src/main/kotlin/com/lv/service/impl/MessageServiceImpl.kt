package com.lv.service.impl

import com.github.pagehelper.PageHelper
import com.lv.enums.ResultEnum
import com.lv.exception.ErrorException
import com.lv.mapper.MessageMapper
import com.lv.model.Message
import com.lv.service.MessageService
import com.lv.util.getStringLength
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(val mMessageMapper: MessageMapper) : MessageService {

    override fun deleteBatch(ids: List<Int>)=mMessageMapper.deleteBatch(ids)

    override fun deleteOne(id: Any?): Int {
        if (id.getStringLength() == 0)
            throw ErrorException(ResultEnum.EMPTY)
        try {
            return mMessageMapper.deleteOne(id as Int)
        } catch (e: Exception) {
            throw ErrorException(ResultEnum.ERROR)
        }
    }

    override fun findAll(command: String?, description: String?, pageNo: Int): List<Message> {
        PageHelper.startPage<List<Message>>(pageNo, 3)
        return mMessageMapper.findAll(command, description)
    }
}