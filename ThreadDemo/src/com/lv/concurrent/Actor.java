package com.lv.concurrent;

/**
 * Date: 2017-04-06
 * Time: 11:16
 * Description:
 */
public class Actor extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " 是一个演员！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + " 登台演出 " + (++count) + " 次");
            keepRunning = (count < 20);
            if (count % 5 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + " 的演出结束了！");
    }

    public static void main(String[] arge) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actress=new Thread(new Actress(),"Ms.Runnable");
        actress.start();
    }
}
