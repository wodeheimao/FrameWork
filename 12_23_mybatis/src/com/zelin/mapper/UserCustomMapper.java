package com.zelin.mapper;

import com.zelin.pojo.User;
import com.zelin.pojo.UsersCustom;

import java.util.List;

public interface UserCustomMapper {
    //查询所有用户(自定义实体类)
    List<UsersCustom>  findAllUsers();



}

