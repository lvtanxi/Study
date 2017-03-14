package com.lv.aop.schema.advices.service;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

/**
 * Date: 2017-03-13
 * Time: 13:47
 * Description:
 */
@Service
public class InvokeService {
    public void invoke(){
        System.out.println("InvokeService invoke");
    }

    public void invokeException(){
       throw new PessimisticLockingFailureException("invokeException");
    }
}
