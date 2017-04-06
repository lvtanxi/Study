package com.lv.concurrent.base;

/**
 * Date: 2017-04-06
 * Time: 11:28
 * Description: 军队线程，模拟作战双方的行为
 */
public class ArmyRunnable implements Runnable{
    //volatile 保证了线程可以正确读取其他线程写入的值
    volatile boolean keepRunning=true;

    @Override
    public void run() {
        while (keepRunning){
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName()+" 进攻对方["+i+"]");
                Thread.yield();//让出处理器时间，让其他线程执行
            }
        }
        System.out.println(Thread.currentThread().getName()+" 結束了战斗");
    }

}
