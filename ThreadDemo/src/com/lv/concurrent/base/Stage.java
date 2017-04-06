package com.lv.concurrent.base;

/**
 * Date: 2017-04-06
 * Time: 11:34
 * Description:
 */
public class Stage extends Thread{
    @Override
    public void run() {
       ArmyRunnable armyRunnable1=new ArmyRunnable();
       ArmyRunnable armyRunnable2=new ArmyRunnable();
       Thread thread1=new Thread(armyRunnable1,"随军");
       Thread thread2=new Thread(armyRunnable2,"农民起义军");

       thread1.start();

       thread2.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>>>>>>");
        KeyPersonThread keyPersonThread = new KeyPersonThread();
        keyPersonThread.setName("程咬金");
        armyRunnable1.keepRunning=false;
        armyRunnable2.keepRunning=false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        keyPersonThread.start();
        try {
            keyPersonThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        keyPersonThread.setName(">>>>>>>>>>>");
    }
    public static void main(String[] args){
        new Stage().start();
    }
}
