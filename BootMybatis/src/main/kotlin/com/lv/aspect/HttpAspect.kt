package com.lv.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

/**
 * Date: 2017-03-21
 * Time: 14:45
 * Description: 切面答应日志
 */
@Aspect
@Component
class HttpAspect {
    @Pointcut("execution(public * com.lv.controller..*(..))")
    fun log() {
    }

    @Before("log()")
    fun doBefore(joinPoint: JoinPoint) {
        startTime.set(System.currentTimeMillis())
        logger.info("================start======================")
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val request = attributes.request
        logger.info("url= {}", request.requestURL)
        logger.info("method= {}", request.method)
        logger.info("ip= {}", request.remoteAddr)
        logger.info("calss method= {}.{}", joinPoint.signature.declaringTypeName, joinPoint.signature.name)
        logger.info("args= {}",joinPoint.args)
        logger.info("parameter args")
        val enu = request.parameterNames
        while (enu.hasMoreElements()) {
            val paraName = enu.nextElement()
            logger.info(paraName + ": " + request.getParameter(paraName))
        }
    }

    @AfterReturning(returning = "any",pointcut = "log()")
    fun doAfterReturning(joinPoint: JoinPoint,any:Any) {//返回值
        logger.info("return value = {}",any)
        logger.info("耗时（毫秒 ）= {} ", (System.currentTimeMillis() - startTime.get()))
        logger.info("================ end======================")
    }

    companion object {
        val logger = LoggerFactory.getLogger(HttpAspect::class.java)!!
        val startTime = ThreadLocal<Long>()
    }
}