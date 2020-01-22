package com.wulang.other;

import com.wulang.springboottest.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OtherConfiguration {
    @Bean
    public Dog ShaSha(){
        Dog dog = new Dog();
        dog.name = "ShaSha";
        return dog;
    }
}
