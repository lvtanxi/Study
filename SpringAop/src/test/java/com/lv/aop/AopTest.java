package com.lv.aop;

import com.lv.base.UnitTestBase;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Date: 2017-03-13
 * Time: 09:45
 * Description:切面编程测试
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AopTest extends UnitTestBase {
    public AopTest() {
        super("classpath*:spring-schema-aop.xml");
    }

  /*  @Test
    public void testBiz() {
        AspectBiz biz = getBean("aspectBiz");
        biz.biz();
    }

    @Test
    public void testInit() {
        AspectBiz biz = getBean("aspectBiz");
        biz.init("lvtanxi", 123);
    }

    @Test
    public void testFit() {
        Fit fit = getBean("aspectBiz");
        fit.filter();
    }
*/
/*    @Test
    public void testSave() {
        InvokeService invokeService = getBean("invokeService");
        invokeService.invoke();
        invokeService.invokeException();
    }*/


}
