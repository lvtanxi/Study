package com.lv.aop.api.introduction;

/**
 * Date: 2017-03-13
 * Time: 14:41
 * Description:
 */
public interface Lockable {
    void  lock();
    void  unlock();
    boolean locked();
}
