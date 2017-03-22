package com.lv.config.interceptor

import com.lv.interceptor.HttpBasicAuthInterceptor
import com.lv.interceptor.TestAuthInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Date: 2017-03-22
 * Time: 09:48
 * Description:注册拦截器 多个拦截器注意顺序如：
 * 拦截器A；拦截器B
 *  请求来是执行 A.preHandle>B.preHandle
 *  其他的都是B的方法先调用
 */
@Configuration
class WebMvcConfigurer : WebMvcConfigurerAdapter(){
    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(HttpBasicAuthInterceptor())?.addPathPatterns("/**") //addPathPatterns是配置拦截路径，可以自己定义哈
        registry?.addWebRequestInterceptor(TestAuthInterceptor())?.addPathPatterns("/**") //addPathPatterns是配置拦截路径，可以自己定义哈
        super.addInterceptors(registry)
    }
}