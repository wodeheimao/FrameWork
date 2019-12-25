package com.zelin.dao;

public interface UserDao {
    void outMoney(int out, double money);

    void inMoney(int in, double money);
}
