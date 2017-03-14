package com.lv.aop.schema.advice.biz;

/**
 * Date: 2017-03-13
 * Time: 09:54
 * Description: 业务类
 */
public class AspectBiz {
    public void biz(){
        System.out.println("AspectBiz biz");
        //throw new RuntimeException();
    }

    public void init(String bizName,int time){
        System.out.println("AspectBiz init:"+bizName+"  "+time);
    }

}
