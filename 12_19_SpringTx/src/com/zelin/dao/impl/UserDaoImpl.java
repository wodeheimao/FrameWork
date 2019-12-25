package com.zelin.dao.impl;

import com.zelin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //转出
    @Override
    public void outMoney(int out, double money) {

        jdbcTemplate.update("update user set banlance = banlance - ? where id =?",money,out);
    }

    //转入
    @Override
    public void inMoney(int in, double money) {
        jdbcTemplate.update("update user set banlance = banlance + ? where id =?",money,in);
    }
}
