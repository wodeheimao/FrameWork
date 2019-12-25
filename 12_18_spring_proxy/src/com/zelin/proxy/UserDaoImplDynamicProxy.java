package com.zelin.proxy;

import com.zelin.dao.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoImplDynamicProxy implements InvocationHandler {
    private UserDao userDao;

    public UserDaoImplDynamicProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        UserDao userDao = (UserDao) Proxy.newProxyInstance(this.userDao.getClass().getClassLoader(),
                this.userDao.getClass().getInterfaces(),
                this);
        return userDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("add")) {
            System.out.println("实现了add的增强");
            return method.invoke(userDao, args);
        }
        System.out.println("不是add方法增强。。。。。。");
        return method.invoke(userDao, args);
    }
}
