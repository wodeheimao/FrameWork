package com.zelin.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo1 {
    @Test
    public  void Test01(){
        //获取ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("myBeans1.xml");
        //使用无参的构造方法
        Object student11 = ac.getBean("student1");
        System.out.println("student11 = " + student11);
        Object student12 = ac.getBean("student1");
        System.out.println("student12 = " + student12);
        System.out.println(student11 == student12);
    }

    @Test
    public  void Test02(){
        //获取ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("myBeans1.xml");
        //使用静态工厂
        Object student2 = ac.getBean("student2");
        System.out.println("student2 = " + student2);
        Object student21 = ac.getBean("student2");
        System.out.println("student21 = " + student21);
    }

    @Test
    public  void Test03(){
        //获取ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("myBeans1.xml");
        //使用工厂类
        Object student3 = ac.getBean("student3");
        System.out.println("student3 = " + student3);
        Object student31 = ac.getBean("student3");
        System.out.println("student31 = " + student31);
        System.out.println(student3 == student31);
    }

}
