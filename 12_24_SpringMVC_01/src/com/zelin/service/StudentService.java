package com.zelin.service;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;

import java.util.List;

public interface StudentService {
    //查询全部学生
    List<Student> findAll();
    //分页查询全部学生
    PageResult<Student> pageList(int page);

    //分页条件查询所有学生
    PageResult<Student> searchPage(Student student, int i);
}
