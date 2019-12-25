package com.zelin.web.service.impl;

import com.zelin.web.dao.StudentDao;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        studentDao.addStudent(student);
    }

    @Override
    public Student findStudentBySid(String sid) throws SQLException {
        return studentDao.findStudentBySid(sid);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(String sid) throws SQLException {
        studentDao.deleteStudent(sid);
    }
}
