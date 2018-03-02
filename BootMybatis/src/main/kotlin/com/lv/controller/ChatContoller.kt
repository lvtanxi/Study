package com.lv.controller

import com.github.pagehelper.PageInfo
import com.lv.dto.ResultDto
import com.lv.model.Message
import com.lv.service.MessageService
import com.lv.util.ResultUtil
import com.lv.util.logger
import org.springframework.web.bind.annotation.*
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

    @GetMapping("talk")
    fun talk() = ModelAndView("talk")

    @GetMapping(value = "loadDatas")
    fun loadDatas(@RequestParam("command") command: String?, @RequestParam("description") description: String?, @RequestParam("pageNo") pageNo: Int): ResultDto {
        logger.info("this param={}", command + description)
        val findAll = mMessageService.findAll(command, description, pageNo)
        return ResultUtil.success(PageInfo<Message>(findAll))
    }

    @PostMapping(value = "deleteOne")
    fun deleteOne(@RequestBody param: Map<String, Any>): ResultDto {
        val updateCount = mMessageService.deleteOne(param["id"])
        return ResultUtil.success(updateCount)
    }
    @PostMapping(value = "deleteBatch")
    fun deleteBatch(@RequestBody ids:List<Int>): ResultDto {
        val updateCount = mMessageService.deleteBatch(ids)
        return ResultUtil.success(updateCount)
    }


}