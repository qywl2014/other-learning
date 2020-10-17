package com.wulang.spring.aop;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AopTest {
    public static void main(String[] args) {
        AspectJProxyFactory factory = new AspectJProxyFactory(new A());
        factory.addAspect(new FirstAspect());
        A a = factory.getProxy();
        System.out.println(a.add(1,3));
    }
}
