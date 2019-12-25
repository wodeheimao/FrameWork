package com.zelin.proxy;

import com.zelin.dao.UserDao;

/**
 * 静态代理的实现，代理目标类
 */
public class UserDaoImplStaticProxy implements UserDao {
    private UserDao userDao;

    public UserDaoImplStaticProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void add() {
        checkSecurity();
        userDao.add();
    }

    @Override
    public void delete() {
        checkSecurity();
        userDao.delete();
    }

    @Override
    public void query() {
        checkSecurity();
        userDao.query();
    }

    @Override
    public void update() {
        checkSecurity();
        userDao.update();
    }

    private void checkSecurity() {
        System.out.println("增强---------------");
    }
}
