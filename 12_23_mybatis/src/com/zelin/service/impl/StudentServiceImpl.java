package com.zelin.service.impl;

import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //根据关键字查询学生列表
    @Override
    public List<Student> findStudentsByKeywords(StudentVo studentVo) {
        return studentMapper.findStudentsByKeywords(studentVo);
    }

    //根据学生查询查询学生列表
    @Override
    public List<Student> findStudentsBySids(StudentVo studentVo) {
        return studentMapper.findStudentsBySids(studentVo);
    }

    //根据关键字及id号一起查询
    @Override
    public List<Student> findStudentsByKeywords2(StudentVo studentVo) {
        return studentMapper.findStudentsByKeywords2(studentVo);
    }
}
