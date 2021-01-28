package com.example.thread02.sync;

/**
 * synchronzied
 *
 * 1.修饰方法和代码块使用的是对象锁（默认当前对象this，可以使用参数传入其他对象，但是不建议）
 */
public class SynchronizedKeyWord {

    private static int money = 0;

    public  void test1() {
        money++;
    }

    public synchronized void test2() {
        System.out.println("test2");
    }

    public static void main(String[] args) {
        SynchronizedKeyWord synchronizedKeyWord = new SynchronizedKeyWord();
        synchronizedKeyWord.test1();
        new Thread(() -> {
            synchronizedKeyWord.test1();
            System.out.println(money);
        }).start();
        System.out.println(money);
    }
}
