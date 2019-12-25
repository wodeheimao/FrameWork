package com.zelin.web.service.impl;

import com.zelin.web.dao.StudentDao;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }
}
