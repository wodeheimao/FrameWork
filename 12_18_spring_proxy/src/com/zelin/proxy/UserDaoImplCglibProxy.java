package com.zelin.proxy;

import com.zelin.dao.UserDao;
import com.zelin.dao.impl.UserDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserDaoImplCglibProxy implements MethodInterceptor {
    private UserDaoImpl userDaoImpl;

    public UserDaoImplCglibProxy(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public UserDaoImpl getUserDao() {
        //新建一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置其父类的class，字节码
        enhancer.setSuperclass(UserDaoImpl.class);
        //回调
        enhancer.setCallback(this);
        UserDaoImpl userDaoImpl = (UserDaoImpl) enhancer.create();
        return userDaoImpl;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("add")) {
            System.out.println("实现了add的增强");
            return methodProxy.invokeSuper(o,objects);
        }
        System.out.println("不是add方法增强。。。。。。");
        return methodProxy.invokeSuper(o,objects);
    }
}
