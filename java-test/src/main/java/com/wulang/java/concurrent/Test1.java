package com.wulang.java.concurrent;

public class Test1 {
    private static final Object lock = new Object();

    public static void main(String[] args) {
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
    }
}
