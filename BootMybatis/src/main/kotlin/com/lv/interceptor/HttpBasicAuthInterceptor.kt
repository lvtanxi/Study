package com.lv.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Date: 2017-03-22
 * Time: 09:40
 * Description:拦截器的实现
 */
class HttpBasicAuthInterceptor :HandlerInterceptor{
    /**
     * 在调用我们方法前拦截，如果返回false 请求返回将被终止
     * any 标识被拦截的目标对象
     */
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, any: Any?): Boolean {
        //设置字符编码
        request?.characterEncoding="utf-8"
        val attribute = request?.session?.getAttribute("user")
        if(attribute!=null)
            println("login user id is $attribute")
        return true
    }

    /**
     * 可以用ModelAndView来改变视图
     */
    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, any: Any?, modelAndView: ModelAndView?) {
    }

    /**
     * 请求结束的时候调用
     */
    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, any: Any?, exception: Exception?) {
    }
}