package com.example.thread01.keymethod;

/**
 * sleep 方法
 *
 * 1.让当前线程进入计时等待状态，等时间到了，进入的是就绪状态而并非是运行状态！
 * 2.各线程启动后 sleep 状态独立(当前线程休眠：应用，如邮件服务器发邮件限流，60 秒内只能发送 30 封，解决方案为发 30 封后 sleep 60秒再发)
 */
public class SleepMethod implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable sleepMehod = new SleepMethod();
        Thread thread1 = new Thread(sleepMehod, "t1");
        thread1.start();

        Runnable sleepMehod2 = new SleepMethod2();
        Thread thread2 = new Thread(sleepMehod2, "t2");
        thread2.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
