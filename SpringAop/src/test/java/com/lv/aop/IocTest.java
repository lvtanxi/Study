package com.lv.aop;

import com.lv.aop.api.BizLogic;
import com.lv.base.UnitTestBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Date: 2017-03-13
 * Time: 15:37
 * Description:
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class IocTest extends UnitTestBase {
    public IocTest() {
        super("classpath*:spring-aop-api.xml");
    }
    @Test
    public void testIoc() {
        BizLogic bizLogic = getBean("bizLogicImpl");
        bizLogic.save();
    }
}
