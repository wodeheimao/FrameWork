package com.zelin.test;

import com.zelin.dao.UserDao;
import com.zelin.dao.impl.UserDaoImpl;
import com.zelin.proxy.UserDaoImplCglibProxy;
import com.zelin.proxy.UserDaoImplDynamicProxy;
import com.zelin.proxy.UserDaoImplStaticProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestProxy {
    @Test
    public void test1(){
        //新建userdao对象
        UserDao userdao = new UserDaoImpl();
        //新建静态代理类
        UserDaoImplStaticProxy usp = new UserDaoImplStaticProxy(userdao);
        usp.add();

    }

    @Test
    public void test2(){
        //新建userdao对象
        UserDao userdao = new UserDaoImpl();
        //新建动态态代理类
        UserDaoImplDynamicProxy udp = new UserDaoImplDynamicProxy(userdao);
        //回去代理对象
        UserDao userDao = udp.getUserDao();
        userDao.add();
        userDao.query();

    }
    @Test
    public void test3(){
        //新建        //UserDaoImpl对象
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        //新建动态态代理类
        UserDaoImplCglibProxy ucp = new UserDaoImplCglibProxy(userDaoImpl);
        //回去代理对象
        UserDaoImpl userDao = ucp.getUserDao();
        userDao.add();
        userDao.query();
    }

    @Autowired
    private UserDao userDao;
    @Test
    public void test4(){
        userDao.add();
    }
}
