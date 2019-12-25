package com.zelin.dao.impl;

import com.zelin.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {
        System.out.println("添加2。。。。。。。。。。。。。。");
    }

    @Override
    public void delete() {
        System.out.println("删除2。。。。。。。。。。。。。。");
    }

    @Override
    public void query() {
        System.out.println("查询2。。。。。。。。。。。。。。");
    }

    @Override
    public void update() {
        System.out.println("修改2。。。。。。。。。。。。。。");
    }
}
