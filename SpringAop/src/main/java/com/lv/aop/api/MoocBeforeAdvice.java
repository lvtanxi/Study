package com.lv.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Date: 2017-03-13
 * Time: 14:07
 * Description:自定义Adavice
 */
public class MoocBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("MoocBeforeAdvice:"+method.getName()+"  "+target.getClass().getName());
    }
}
