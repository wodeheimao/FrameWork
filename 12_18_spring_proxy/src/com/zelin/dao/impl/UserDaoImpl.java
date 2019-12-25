package com.zelin.dao.impl;

import com.zelin.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("添加。。。。。。。。。。。。。。");
    }

    @Override
    public void delete() {
        System.out.println("删除。。。。。。。。。。。。。。");
    }

    @Override
    public void query() {
        System.out.println("查询。。。。。。。。。。。。。。");
    }

    @Override
    public void update() {
        System.out.println("修改。。。。。。。。。。。。。。");
    }
}
