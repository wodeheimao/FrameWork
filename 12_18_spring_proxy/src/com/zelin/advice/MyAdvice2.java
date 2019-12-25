package com.zelin.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice2 {
    @Pointcut("execution(* com.zelin.dao.impl.*DaoImpl2.*(..))")
    public void pc() {

    }
    @Before("MyAdvice2.pc()")
    public void before() {
        System.out.println("这是前置通知-------------");
    }

    @AfterReturning("MyAdvice2.pc()")
    public void afterRunning() {
        System.out.println("这是后置通知（return，抛出异常不显示）-------------");
    }

    @Around("MyAdvice2.pc()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知-----前");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知-----后");
    }
    @AfterThrowing("MyAdvice2.pc()")
    public void afterThrowing() {
        System.out.println("这是抛出异常通知-------------");
    }

    @After("MyAdvice2.pc()")
    public void after() {
        System.out.println("这是后置通知（抛出异常也调用）-------------");
    }
}
