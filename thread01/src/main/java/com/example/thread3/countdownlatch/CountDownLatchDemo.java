package com.example.thread3.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 1.是一个同步的辅助类，允许一个或多个线程一直等待，直到其它线程完成它们的操作。
 * 2.它常用的API其实就两个:await()和countDown()
 * 3.count初始化CountDownLatch，然后需要等待的线程调用await方法。await方法会一直受阻塞直到count=0。而其它线程完成自己的操作后，调用countDown()使计数器count减1。当count减到0时，所有在等待的线程均会被释放
 *
 */
public class CountDownLatchDemo {

    // 模拟最后下班（一个线程等待多个线程完成）、也可以模拟多个开发等待产品经理需求评审（多个等一个）
    public static void main(String[] args) {
        // 等待 5 个线程完成（5 个同事工作完成计数器）
        CountDownLatch countDownLatch = new CountDownLatch(5);
        // 自己
        new Thread(
                () -> {
                    try {
                        // await方法会一直受阻塞直到count=0
                        countDownLatch.await();
                        System.out.println("都下班了，我也走了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
        ).start();

        // 其他同事
        for (int i=0; i<5; i++) {
            new Thread(
                    () -> {
                        // await方法会一直受阻塞直到count=0
                        System.out.println("同事xxx下班了,计数器-1");
                        countDownLatch.countDown();
                    }
            ).start();
        }
    }
}
