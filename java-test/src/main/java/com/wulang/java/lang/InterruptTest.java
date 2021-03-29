package com.wulang.java.lang;

public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                long now = System.currentTimeMillis();
                while(System.currentTimeMillis()-now<1000){

                }
                System.out.println("before");
                Thread.sleep(5000);
                System.out.println("after");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        thread.interrupt();
        thread.start();
    }
}
