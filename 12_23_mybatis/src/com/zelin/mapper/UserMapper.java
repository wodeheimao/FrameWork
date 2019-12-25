package com.zelin.mapper;

import com.zelin.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //查询所有用户(使用映射结果集)
    List<User> findAllUsers2();

    //查询所有用户(使用懒加载)
    List<User> findAllUsers3();

    @Select("select * from tb_user where uid = #{value}")
    User findUserByUid(int uid);
}
