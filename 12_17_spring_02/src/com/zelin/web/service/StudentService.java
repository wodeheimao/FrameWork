package com.zelin.web.service;

import com.zelin.web.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    //查询所有学生
    List<Student> findAll() throws SQLException;

    //新增一个学生
    void addStudent(Student student) throws SQLException;

    //根据sid查找一个学生
    Student findStudentBySid(String sid) throws SQLException;

    //更新一个学生信息
    void updateStudent(Student student) throws SQLException;

    //根据sid删除一个学生
    void deleteStudent(String sid) throws SQLException;
}
