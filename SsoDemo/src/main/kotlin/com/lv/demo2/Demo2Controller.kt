package com.lv.demo2
import com.lv.util.SSOCheck
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.servlet.ModelAndView

/**
 * Date: 2017-04-07
 * Time: 13:50
 * Description:
 */
@RestController
class Demo2Controller {
    @GetMapping("demo2")
    fun main():ModelAndView{
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        val checkKookie = SSOCheck.checkKookie(request)
        return if (checkKookie) ModelAndView("success2") else  ModelAndView("login")
    }
}