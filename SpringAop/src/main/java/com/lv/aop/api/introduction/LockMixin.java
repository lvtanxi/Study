package com.lv.aop.api.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Date: 2017-03-13
 * Time: 14:42
 * Description:
 */
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {
    private boolean locked;

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    public boolean locked() {
        return locked;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (locked() && mi.getMethod().getName().indexOf("set") == 0)
            throw new RuntimeException();
        return super.invoke(mi);
    }
}
