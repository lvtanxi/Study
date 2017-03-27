package com.lv.service.impl

import com.lv.mapper.CommandMapper
import com.lv.service.CommandService
import org.springframework.stereotype.Service

@Service
class CommandServiceImpl(val mCommandMapper: CommandMapper) : CommandService {
    override fun findAllCommand()=mCommandMapper.findAllCommand()
}