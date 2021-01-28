package com.example.thread3.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 * 1.允许一组线程相互等待直到遇到公共标识
 * 2.可以被重用
 */
public class CyclicBarrierDemo {


    /**
     * 模拟两个人约定到一个地点开始聚餐
     * @param args
     */
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        for (int i=0; i<2; i++) {

            new Thread(
                    () -> {
                        String name = Thread.currentThread().getName();
                        if ("Thread-0".equals(name)) {
                            name = "小明";
                        } else {
                            name = "小红";
                        }
                        System.out.println(name+"到了餐厅");
                        try {
                            cyclicBarrier.await();
                            System.out.println("都到了餐厅开始聚餐");

                            System.out.println(name+"到了家开始洗澡");
                            cyclicBarrier.await();

                            System.out.println("都洗澡后开始聊天");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            ).start();
        }
    }
}
