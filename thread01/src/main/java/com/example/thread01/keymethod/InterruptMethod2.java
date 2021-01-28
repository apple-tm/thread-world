package com.example.thread01.keymethod;

/**
 * 执行应该中断方法后，sleep 等阻塞的方法会导致中断异常 InterruptedException
 */
public class InterruptMethod2 {

    Runnable runnable = () -> {
        int i = 0;
        try {
            while (i < 1000) {
                System.out.println("中断："+Thread.currentThread().isInterrupted());
                // 睡个半秒钟我们再执行
                Thread.sleep(500);
                System.out.println(i++);
            }
        } catch (InterruptedException e) {
            // 判断该阻塞线程是否还在
            System.out.println(Thread.currentThread().isAlive());

            // 判断该线程的中断标志位状态
            System.out.println(Thread.currentThread().isInterrupted());

            System.out.println("In Runnable");
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        InterruptMethod2 interruptMethod2 = new InterruptMethod2();
        // 创建线程并启动
        Thread t = new Thread(interruptMethod2.runnable);
        System.out.println("This is main ");
        t.start();
        try {
            // 在 main线程睡个3秒钟
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("In main");
            e.printStackTrace();
        }
        // 设置中断
        t.interrupt();
    }
}
