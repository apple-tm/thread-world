package com.example.thread01.keymethod;

/**
 * 中断方法的作用：
 * 1.设置线程中断标识，告诉线程对象应该结束了
 * 2.在 run 中判断当前线程中断标识可以针对不同的中断状态执行不同的逻辑
 */
public class InterruptMethod {

    public static void main(String[] args) {
//         new Runnable匿名内部类（可以由 lamda 表达式取代），使用接口初始化一个没有定义类的对象

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!Thread.currentThread().isInterrupted()) {
//                    //  如果没有中断标识
//                    System.out.println(Math.random());
//                }
//                // 存在中断标识，需要安全结束线程
//                System.out.println("调用 interrupt 执行 打印中断安全结束");
//            }
//        });
        Thread t1 = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    //  如果没有中断标识
                    System.out.println(Math.random());
                }
                // 存在中断标识，需要安全结束线程
                System.out.println("调用 interrupt 执行 打印中断安全结束");
        });
        t1.start();
        try {
            System.out.println("没有调用 interrupt 执行 10ms 的打印随机数");
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
