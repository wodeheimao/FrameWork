package com.zelin.dao;

import com.zelin.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    Student findSudent(int sid);

    void deleteStudent(int sid);

    void addStudent(Student student);

    void updateSudent(Student student);

    Long findCount();
}
