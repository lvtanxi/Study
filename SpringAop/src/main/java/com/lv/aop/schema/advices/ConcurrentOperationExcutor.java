package com.lv.aop.schema.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.PessimisticLockingFailureException;

/**
 * Date: 2017-03-13
 * Time: 13:35
 * Description:
 */
public class ConcurrentOperationExcutor {
    private int mMaxRetries = 2;
    private int mOrder;

    public void setMaxRetries(int maxRetries) {
        mMaxRetries = maxRetries;
    }

    public int getMaxRetries() {
        return mMaxRetries;
    }

    public void setOrder(int order) {
        mOrder = order;
    }

    public int getOrder() {
        return mOrder;
    }

    public Object dooncurrentOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException lockingFailureException;
        do {
            numAttempts++;
            System.out.println("Try times:" + numAttempts);
            try {
                return proceedingJoinPoint.proceed();
            } catch (PessimisticLockingFailureException ex) {
                lockingFailureException = ex;
            }
        } while (numAttempts <= this.mMaxRetries);
        System.out.println("Try error:" + numAttempts);
        return lockingFailureException;
    }
}
