package com.zelin.web.service.impl;

import com.zelin.web.mapper.StudentMapper;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    //查询所有学生
    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void deleteStudent(String sid) {
        studentMapper.deleteStudent(sid);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
}
