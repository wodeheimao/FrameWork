package com.zelin.service;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;

public interface StudentService {
    //分页条件查询
    PageResult search(Integer page, Integer pageSize, Student student);
    //添加学生
    void addStu(Student student);
    //删除学生
    void deleteStu(String sid);

    //修改学生
    void updateStu(Student student);
}
