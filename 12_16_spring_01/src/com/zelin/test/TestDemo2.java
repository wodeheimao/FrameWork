package com.zelin.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo2 {
    @Test
    public void Test01() {
        //获取ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("myBeans2.xml");
        //使用set设置属性
        Object student1 = ac.getBean("student1");
        System.out.println("使用set设置属性"+student1);
        //使用构造方式
        Object student2 = ac.getBean("student2");
        System.out.println("使用构造方式 "+student2);
        //使用p命名空间
        Object student3 = ac.getBean("student3");
        System.out.println("使用p命名空间 "+student3);
        //使用spel 注入
        Object student4 = ac.getBean("student4");
        System.out.println("使用spel 注入"+student4);
    }
}