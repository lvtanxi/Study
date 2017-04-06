package com.lv.concurrent.base;

/**
 * Date: 2017-04-06
 * Time: 11:42
 * Description:
 */
public class KeyPersonThread extends Thread{
    @Override
    public void run() {
        System.out.println(getName()+" 开始了战斗");
        for (int i = 1; i < 11; i++) {
            System.out.println(Thread.currentThread().getName()+" 左突右杀，攻击隋军");
        }
        System.out.println(getName()+" 结束了战斗");
    }
}
