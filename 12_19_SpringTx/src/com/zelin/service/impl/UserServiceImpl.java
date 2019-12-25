package com.zelin.service.impl;

import com.zelin.dao.UserDao;
import com.zelin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    //转账
    @Override
    public void transf(int out, int in, double money) {
        //转出
        userDao.outMoney(out,money);
        int n = 1/0;
        //转入
        userDao.inMoney(in,money);
    }
}
