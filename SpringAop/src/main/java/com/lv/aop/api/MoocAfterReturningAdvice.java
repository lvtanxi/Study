package com.lv.aop.api;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Date: 2017-03-13
 * Time: 14:16
 * Description:
 */
public class MoocAfterReturningAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("MoocAfterReturningAdvice:" + method.getName() + " " + target.getClass().getName());
    }
}
