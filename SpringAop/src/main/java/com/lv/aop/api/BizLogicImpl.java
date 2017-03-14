package com.lv.aop.api;

/**
 * Date: 2017-03-13
 * Time: 14:01
 * Description:
 */
public class BizLogicImpl implements BizLogic {
    public String save() {
        System.out.println("BizLogicImpl save");
        //throw new RuntimeException();
        return "BizLogicImpl save";
    }
}
