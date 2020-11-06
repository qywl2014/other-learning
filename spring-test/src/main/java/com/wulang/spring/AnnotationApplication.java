package com.wulang.spring;

import com.wulang.spring.domain.HelloImpl;
import com.wulang.spring.service.Hello;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(HelloImpl.class)
@Configuration
public class AnnotationApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnotationApplication.class);
        annotationConfigApplicationContext.getBean(Hello.class).hi();
    }

    public void hello(){
        System.out.println("hello");
    }
}
