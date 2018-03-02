package org.seckill.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Aspect
@Order(1)
@Component
public class CommonAspect {

    private static Logger log =null;
    @Pointcut("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public void pointcut(){}


    @Around("pointcut()")
    public Object logRcord(ProceedingJoinPoint point)throws Throwable{
        Class type = point.getSignature().getDeclaringType();
        log = LoggerFactory.getLogger(type);
        Object[] args = point.getArgs();
        String methodName = point.getSignature().getName();
        Map returnMap = null;
        String requestLogString = String.format("【%s】【Arguments】：%s",methodName,Arrays.toString(args));
        log.info(requestLogString);
        Object res = null;
        return point.proceed();

    }
}
