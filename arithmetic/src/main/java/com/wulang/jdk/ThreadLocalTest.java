package com.wulang.jdk;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.get();
    }

}
