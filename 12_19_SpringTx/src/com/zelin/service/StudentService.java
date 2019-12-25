package com.zelin.service;

import com.zelin.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findSudent(int sid);

    void deleteSudent(int sid);

    void addSudent(Student student);

    void updateSudent(Student student);

    Long findCount();
}
