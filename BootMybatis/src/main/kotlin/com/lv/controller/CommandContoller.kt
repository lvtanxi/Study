package com.lv.controller

import com.lv.service.CommandService
import com.lv.util.ResultUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Date: 2017-03-27
 * Time: 11:12
 * Description:
 */
@RestController
@RequestMapping("command")
class CommandContoller(val mCommandService: CommandService) {
    @GetMapping(value = "findAllCommand")
    fun findAllCommand()=ResultUtil.success(mCommandService.findAllCommand())
}