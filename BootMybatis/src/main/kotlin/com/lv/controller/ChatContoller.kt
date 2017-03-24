package com.lv.controller

import com.lv.dto.ResultDto
import com.lv.service.MessageService
import com.lv.util.ResultUtil
import com.lv.util.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * Date: 2017-03-23
 * Time: 14:40
 * Description:
 */
@RestController
@RequestMapping("chat")
class ChatContoller(val mMessageService: MessageService) {

    @GetMapping(value = "list")
    fun list() = ModelAndView("list")

    @GetMapping(value = "loadDatas")
    fun loadDatas(@RequestParam("command")command:String?,@RequestParam("description")description:String?,@RequestParam("pageNo")pageNo:Int) :ResultDto{
        logger.info("this param={}",command+description)
        val findAll = mMessageService.findAll(command,description,pageNo)
        return ResultUtil.success(findAll)
    }
}