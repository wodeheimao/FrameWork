package com.zelin.advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;

import	java.util.Calendar;

public class MyAdvice {

    public void before() {
        System.out.println("这是前置通知-------------");
    }

    public void afterRunning(){
        System.out.println("这是后置通知（return，抛出异常不显示）-------------");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知-----前");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知-----后");
    }
    public void afterThrowing() {
        System.out.println("这是抛出异常通知-------------");
    }
    public void after() {
        System.out.println("这是后置通知（抛出异常也调用）-------------");
    }
}
