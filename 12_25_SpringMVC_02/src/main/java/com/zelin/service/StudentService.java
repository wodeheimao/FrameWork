package com.zelin.service;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;

import java.util.List;

public interface StudentService {
    //查询所有学生
    List<Student> findAll();

    //分页查询所有学生
    PageResult pageList(int page, int pageSize);
}
