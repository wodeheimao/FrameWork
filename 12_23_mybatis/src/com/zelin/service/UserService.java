package com.zelin.service;

import com.zelin.pojo.IdCard;
import com.zelin.pojo.User;
import com.zelin.pojo.UsersCustom;

import java.util.List;

public interface UserService {
    //查询所有用户(自定义实体类)
    List<UsersCustom> findAllUsers();
    //查询所有用户(使用映射结果集)
    List<User> findAllUsers2();

    //查询所有用户(使用懒加载)
    List<User> findAllUsers3();

    IdCard findIdCardById(int i);
}
