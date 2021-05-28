package com.example.thread01.keymethod;

/**
 * join()方法
 *
 * 1.功能：等待该线程执行完才执行别的线程waits for this thread to die
 * 2.注意：join 代码位置要放在其他线程（main 线程除外） start 之前否则会失效（这是因为 main 线程释放了锁，不再继续向下执行）
 * 3.该方法对于有前后顺序关系的任务十分有效
 */
public class JoinMethod implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());

            if (Thread.currentThread().getName().equals("top1")) {
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new JoinMethod();
        Thread thread1 = new Thread(runnable, "top1");
        Thread thread2 = new Thread(runnable, "top2");
        thread1.start();
        try {
            // 执行 join 的线程 wait 直到 thread1 执行完，thread1调用 notify 其他线程（包括 main 线程）进入就绪
            // thread1 join 获取当前对象的锁，其他线程阻塞直到 thread1 notify 释放锁，其他线程进入就绪
            thread1.join();
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
