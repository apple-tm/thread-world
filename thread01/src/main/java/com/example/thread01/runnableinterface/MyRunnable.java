package com.example.thread01.runnableinterface;

/**
 * 1.实现 Runable 接口
 * 2.重写 run 方法
 * 3.注意 Runable 对象要做为参数传递给 Thread 的构造函数才能创建线程
 * 4.run 和 start 的区别：run 封装了被线程执行的代码，start 启动线程，然后 jvm 调用线程的 run 方法
 * 5.为什么要使用 Runable：1 运行任务和线程类解耦。2.避免单继承，可执行接口实现类还应该可以实现其它接口
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
//        for (int i=0; i<200; i++) {
//            System.out.println(i);
//        }
        // thread 可以修改自己的线程名
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // 可运行的接口实现类，并不是线程类,运行任务和线程类(运行容器、执行工厂)解耦
        Runnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable, "top1");
        Thread thread2 = new Thread(runnable, "top2");
        // 该线程相对与主线程异步，该线程的生命周期就是 run 方法的生命周期，而主线程会一直向下执行
        // 主线程启动一个线程后继续向下执行不会执行其他线程的任务，此所谓多线程
        thread1.start();
        thread2.setDaemon(true);
        thread2.start();
        System.out.println(Thread.currentThread().getName());
    }

}
