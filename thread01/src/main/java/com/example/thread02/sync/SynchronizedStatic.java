package com.example.thread02.sync;

/**
 * 类锁和对象锁是不会冲突的
 * 1.类锁(类的字节码文件对象)
 * 2.synchronized修饰普通方法或代码块获取的是对象锁。
 */
public class SynchronizedStatic {

    public synchronized void test1() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }

    public static synchronized void test2() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }

    public static void main(String[] args) {
        final SynchronizedStatic demo = new SynchronizedStatic();

        // 创建线程执行静态方法
        Thread t1 = new Thread(() -> {
            try {
                test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建线程执行实例方法
        Thread t2 = new Thread(() -> {
            try {
                demo.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 启动
        t1.start();
        t2.start();
    }
}
