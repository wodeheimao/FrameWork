package com.zelin.service;

import com.zelin.pojo.Classes;

import java.util.List;

public interface ClassesService {
    //查询班级(使用自定义ResultMap完成)
    List<Classes> findAllClasses();

    //查询所有班级(使用关联查询完成)
    List<Classes> findAllClasses2();
}
