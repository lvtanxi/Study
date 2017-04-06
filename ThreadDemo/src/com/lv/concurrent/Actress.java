package com.lv.concurrent;

/**
 * Date: 2017-04-06
 * Time: 11:23
 * Description:
 */
public class Actress implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " 是一个演员！>>>>>>>>");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName()+ " 登台演出 " + (++count) + " 次>>>>>>>>");
            keepRunning = (count < 20);
            if (count % 5 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+ " 的演出结束了！>>>>>>>>");
    }
}
