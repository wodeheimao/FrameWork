package com.zelin.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo3 {
    @Test
    public void Test01() {
        //获取ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("myBeans3.xml");
        //使用set设置属性
        Object collectionBean = ac.getBean("collectionBean");
        System.out.println("collectionBean = " + collectionBean);
    }
}