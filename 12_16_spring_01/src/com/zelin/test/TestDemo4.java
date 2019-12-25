package com.zelin.test;

import com.zelin.pojo.JdbcUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class TestDemo4 {
    @Test
    public void Test01() {
        //获取ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("myBeans4.xml");

        JdbcUtils jdbcUtils = (JdbcUtils) ac.getBean("jdbcUtils");
        Connection connection = jdbcUtils.getConnection();
        System.out.println("connection = " + connection);
    }
}