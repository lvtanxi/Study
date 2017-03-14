package com.lv.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Date: 2017-03-13
 * Time: 14:28
 * Description:
 */
public class MoocMethodInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MoocMethodInterceptor invoke " + methodInvocation.getMethod().getName() + "  " + methodInvocation.getStaticPart().getClass().getName());
        Object proceed = methodInvocation.proceed();
        System.out.println("MoocMethodInterceptor " + proceed);
        return proceed;
    }
}
