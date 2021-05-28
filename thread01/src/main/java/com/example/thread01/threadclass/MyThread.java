package com.example.thread01.threadclass;

/**
 * 1.继承 Thread 类
 * 2.重写 run 方法
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<200; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        // 测试结果：两个线程交替执行 run 方法中的代码
    }
}
