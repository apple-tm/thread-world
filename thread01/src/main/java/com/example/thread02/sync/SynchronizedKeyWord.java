package com.example.thread02.sync;

/**
 * synchronzied
 *
 * 1.修饰方法和代码块使用的是对象锁（默认当前对象this，可以使用参数传入其他对象，但是不建议）
 */
public class SynchronizedKeyWord {

    public static   int money = 0;

    /**
     * ++
     * 1. 获取值
     * 2. 值+1
     * 3. 设置值
     */
    public static synchronized   void test1() {
        money++;
    }

    public synchronized void test2() {
        System.out.println("test2");
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SynchronizedKeyWord synchronizedKeyWord = new SynchronizedKeyWord();
        SynchronizedKeyWord synchronizedKeyWord2 = new SynchronizedKeyWord();


        for (int i=1; i<=50; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SynchronizedKeyWord.test1();
                SynchronizedKeyWord.test1();
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(SynchronizedKeyWord.money);
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}
