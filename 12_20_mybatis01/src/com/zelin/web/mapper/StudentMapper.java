package com.zelin.web.mapper;

import com.zelin.web.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生
    List<Student> findAll();

    void addStudent(Student student);

    void deleteStudent(String sid);

    void updateStudent(Student student);
}
