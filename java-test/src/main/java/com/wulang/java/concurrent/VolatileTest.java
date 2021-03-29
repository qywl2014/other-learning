package com.wulang.java.concurrent;

public class VolatileTest {
    private static int isSuccess = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                isSuccess = 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (isSuccess == 0) {
            Thread.yield();
//            System.out.println(1);
        }
        System.out.println("success ...");
    }
}
