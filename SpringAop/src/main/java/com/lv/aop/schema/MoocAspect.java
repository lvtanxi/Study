package com.lv.aop.schema;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Date: 2017-03-13
 * Time: 09:53
 * Description:  切面类
 */
public class MoocAspect {
    /**
     * 前置通知
     */
    public void beforeM(){
        System.out.println("MoocAspect beforeM");
    }

    /**
     * 返回后通知
     * @param joinPoint 连接点
     * @throws Throwable 运行时异常
     */
    public void afterReturningM(JoinPoint joinPoint) throws Throwable {
        System.out.println("MoocAspect afterReturningM"+joinPoint.getKind());
    }
    /**
     * 异常通知(需要删除AspectBiz中的异常注释)
     * @param joinPoint 连接点
     * @throws Throwable 运行时异常
     */
    public void afterThrowingM(JoinPoint joinPoint) throws Throwable {
        System.out.println("MoocAspect afterThrowingM"+joinPoint.getKind());
    }

    /**
     * 后置通知
     * @param joinPoint 连接点
     * @throws Throwable 运行时异常
     */
    public void afterM(JoinPoint joinPoint) throws Throwable {
        System.out.println("MoocAspect afterM"+joinPoint.getKind());
    }

    /**
     * 环绕通知(需要注意的ProceedingJoinPoint)
     * @param proceedingJoinPoint 连接点
     * @throws Throwable 运行时异常
     */
    public Object aroundM(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("MoocAspect aroundM");
        return  proceedingJoinPoint.proceed();
    }

    /**
     * 环绕通知(需要注意的ProceedingJoinPoint)
     * @param proceedingJoinPoint 连接点
     * @throws Throwable 运行时异常
     */
    public Object afterInitM(ProceedingJoinPoint proceedingJoinPoint, String bizName, int time) throws Throwable {
        System.out.println("MoocAspect afterInitM "+bizName+">"+time);
        return proceedingJoinPoint.proceed();
    }
}
