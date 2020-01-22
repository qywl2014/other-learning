package com.wulang.spring.domain;

import com.wulang.spring.service.Hello;

public class HelloImpl implements Hello {
    @Override
    public String hi() {
        System.out.println("hi....");
        return null;
    }
}
