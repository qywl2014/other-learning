package com.wulang.springboottest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Bean
    @ConditionalOnBean(Cat.class)
    @ConditionalOnProperty(value = "com.wulang.enabled",
            matchIfMissing = true)
    @ConfigurationProperties("dog")
    public Dog getDog(){
        return new Dog();
    }
}
