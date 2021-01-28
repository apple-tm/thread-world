package com.example.thread02.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable
 * 1.ExecutorService
 * 2.Future<T> </>submit(Callable)
 * 3.shutdown()等待任务执行完才中断线程，而shutdownNow()不等任务执行完就中断了线程。
 */
public class CallableAndFuture {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = pool.submit(new MyCallable(100));
        Future<Integer> f2 = pool.submit(new MyCallable(10));
        System.out.println(f1.get());
        System.out.println(f2.get());

        pool.shutdown();
        pool.shutdownNow();
    }
}

class MyCallable implements Callable<Integer> {

    private int number;

    public MyCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=0; i<number; i++) {
            sum += i;
        }
        return sum;
    }
}
