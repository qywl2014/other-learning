package com.wulang.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FirstAspect {

    @Around("execution(* com.wulang.spring.aop.A.add(..))")
    public Object a(ProceedingJoinPoint pjp) throws Throwable {
        for (Object arg : pjp.getArgs()) {
            System.out.println("arg: " + arg);
        }
        return pjp.proceed();
    }
}
