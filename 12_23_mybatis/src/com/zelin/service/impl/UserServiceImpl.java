package com.zelin.service.impl;

import com.zelin.mapper.IdcardMapper;
import com.zelin.mapper.UserCustomMapper;
import com.zelin.mapper.UserMapper;
import com.zelin.pojo.IdCard;
import com.zelin.pojo.User;
import com.zelin.pojo.UsersCustom;
import com.zelin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserCustomMapper userCustomMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdcardMapper idcardMapper;

    //查询所有用户(自定义实体类)
    @Override
    public List<UsersCustom> findAllUsers() {
        return userCustomMapper.findAllUsers();
    }

    //查询所有用户(使用映射结果集)
    @Override
    public List<User> findAllUsers2() {
        return userMapper.findAllUsers2();
    }

    //查询所有用户(使用懒加载)
    @Override
    public List<User> findAllUsers3() {
        return userMapper.findAllUsers3();
    }

    @Override
    public IdCard findIdCardById(int i) {
        return idcardMapper.findIdCardById(i);
    }
}
