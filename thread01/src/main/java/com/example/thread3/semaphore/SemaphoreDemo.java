package com.example.thread3.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * 1.小店一次只能容纳5个顾客挑选购买，超过5个就需要排队啦~~~
 * 2.semaphore.acquire(); semaphore.release(); 10 个信号量代表最多十个线程并发
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 模拟 50 个人排队超市买东西，疫情控制每次超市只能进 10 人，分 5 批
        int personNums = 50;
        Semaphore semaphore = new Semaphore(10);
        for (int i=0; i< personNums; i++) {
            int f = i;
            new Thread(
                    () -> {
                        try {
                            // 消耗一个信号量
                            semaphore.acquire();
                            System.out.println("客户"+f+"正在购买商品");
                            Thread.sleep(1000);
                            System.out.println("客户"+f+"购买商品完成离开超市");
                            semaphore.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            ).start();
        }
    }
}
