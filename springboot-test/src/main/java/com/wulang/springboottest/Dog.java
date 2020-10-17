package com.wulang.springboottest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


public class Dog {
    private String name = "DingDing";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
