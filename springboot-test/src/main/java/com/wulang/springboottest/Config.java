package com.wulang.springboottest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Dog getDog(){
        return new Dog();
    }
}
