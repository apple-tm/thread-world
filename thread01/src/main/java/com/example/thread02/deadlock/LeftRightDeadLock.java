package com.example.thread02.deadlock;

public class LeftRightDeadLock {

    public final Object left = new Object();
    public final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                System.out.println("leftRight");
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                System.out.println("rightLeft");
            }
        }
    }

    public static void main(String[] args) {
        LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock();
        new Thread(() -> {
            leftRightDeadLock.leftRight();
        }).start();
        new Thread(() -> {
            leftRightDeadLock.rightLeft();
        }).start();
    }
}
