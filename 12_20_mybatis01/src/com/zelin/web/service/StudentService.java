package com.zelin.web.service;

import com.zelin.web.pojo.Student;

import java.util.List;

public interface StudentService {
    //查询所有学生
    List<Student> findAll();

    void addStudent(Student student);

    void deleteStudent(String sid);

    void updateStudent(Student student);
}
