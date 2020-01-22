package com.wulang.spring;

import com.wulang.spring.service.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("conf/spring-context.xml");
        Hello hello=(Hello) applicationContext.getBean("hello");
        for(int i=0;i<1;i++){
            hello.hi();
        }

    }
}
