package com.lv.interceptor

import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

/**
 * Date: 2017-03-22
 * Time: 09:40
 * Description:拦截器的实现
 */
class TestAuthInterceptor :WebRequestInterceptor{
    override fun preHandle(p0: WebRequest?) {
    }

    override fun postHandle(p0: WebRequest?, p1: ModelMap?) {
    }

    override fun afterCompletion(p0: WebRequest?, p1: Exception?) {
    }
}