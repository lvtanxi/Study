package com.lv.controller

import com.lv.util.SSOCheck
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.Cookie


/**
 * Date: 2017-04-07
 * Time: 10:49
 * Description:
 */
@RestController
class LoginController{

    @GetMapping("login")
    fun login()= ModelAndView("login")

    @PostMapping("doLogin")
    fun doLogin(@RequestParam("userName") userName: String?,@RequestParam("passWord") passWord: String?,@RequestParam("toToUrl") toToUrl: String?):String{
        println(">>>>>>>>>>>"+toToUrl)
        val checkLogin = SSOCheck.checkLogin(userName, passWord)
        if (checkLogin) {
            val cookie = Cookie("ssocookie","ss0")
            //想多个域(同父域)共享cookie的话要这样做
            cookie.domain="localhost"
            cookie.path="/"
            val response = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).response
            val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
            println(request.requestURL)
            response.addCookie(cookie)
            request.session.setAttribute("lvtanxi","lvtanxi")
            return toToUrl.toString()
        }
        return "error"
    }

}
