package com.wulang.java.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    private static final Object lock = new Object();

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        // Object.wait()
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("object wait start");
                    lock.wait();
                    System.out.println("object wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t-object-wait").start();

        // Thread.sleep()
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    System.out.println("sleep start");
                    Thread.sleep(Long.MAX_VALUE);
                    System.out.println("sleep end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t-sleep").start();

        // synchronized
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("synchronized start");
                synchronized (lock) {
                    System.out.println("synchronized end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t-synchronized").start();

        // reentrantLock-sleep
        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("t-sleep-2-start");
                Thread.sleep(Long.MAX_VALUE);
                System.out.println("t-sleep-2-end");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "t-sleep-2").start();

        // reentrantLock-lock
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("t-reentrantLock-lock-start");
                reentrantLock.lock();
                System.out.println("t-reentrantLock-lock-end");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "t-reentrantLock-lock").start();
    }
}
