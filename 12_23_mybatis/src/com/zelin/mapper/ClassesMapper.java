package com.zelin.mapper;

import com.zelin.pojo.Classes;
import com.zelin.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassesMapper {


    //查询班级(使用自定义ResultMap完成)
    List<Classes> findAllClasses();

    //查询所有班级(使用关联查询完成)
    List<Classes> findAllClasses2();
}


