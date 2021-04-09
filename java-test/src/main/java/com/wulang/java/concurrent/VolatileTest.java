package com.wulang.java.concurrent;

import com.wulang.java.domain.A;

public class VolatileTest {
    private static int isSuccess = 0;
    private static int[] a = new int[1000000000];

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                isSuccess = 1;
                System.out.println("update to success "+ A.count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (isSuccess == 0) {
            int a = 1;
            int b = a + 4;
            A.count++;
//            if ( % 1000000 == 0) {
//                count.getAndAdd(1);
//            }
//            Thread.yield();
//            System.out.println(1);
        }
        System.out.println("success ...");
    }
}
