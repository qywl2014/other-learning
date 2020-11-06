package com.wulang.springboottest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
//@Configuration
//@EnableConfigurationProperties(Dog.class)
@ConfigurationProperties("dog")
public class Dog {
    private String name = "DingDing";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
