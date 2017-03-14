package com.lv.aop.api.introduction;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Date: 2017-03-13
 * Time: 14:45
 * Description:
 */
public class LockMixinAdvisor extends DefaultIntroductionAdvisor {
    public LockMixinAdvisor(Advice advice) {
        super(new LockMixin(),Lockable.class);
    }
}
