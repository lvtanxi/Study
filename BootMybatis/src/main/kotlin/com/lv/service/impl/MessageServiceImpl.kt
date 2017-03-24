package com.lv.service.impl

import com.github.pagehelper.PageHelper
import com.lv.mapper.MessageMapper
import com.lv.model.Message
import com.lv.service.MessageService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(val mMessageMapper: MessageMapper) : MessageService {
    override fun findAll(command:String?, description:String?,pageNo:Int):List<Message>{
        PageHelper.startPage<List<Message>>(pageNo,10)
        return mMessageMapper.findAll(command,description)
    }
}