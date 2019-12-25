package com.zelin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Classes;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentExample;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    ClassesMapper classesMapper;

    //查询所有学生
    @Override
    public List<Student> findAll() {
        //查询所有学生
        List<Student> studentList = studentMapper.selectByExample(null);
        //遍历学生
        for (Student student : studentList) {
            Classes classes = classesMapper.selectByPrimaryKey(student.getCid());
            //得到学生班级
            student.setCname(classes.getCname());
        }
        return studentList;
    }

    //分页查询所有学生
    @Override
    public PageResult pageList(int page, int pageSize) {
        //开启分页
        PageHelper.startPage(page,pageSize);
        //查询所有学生
        StudentExample expample = new StudentExample();
        List<Student> studentList = studentMapper.selectByExample(expample);
        //遍历学生
        for (Student student : studentList) {
            Classes classes = classesMapper.selectByPrimaryKey(student.getCid());
            //得到学生班级
            student.setCname(classes.getCname());
        }
        Page<Student> pageStu = (Page<Student>) studentList;
        return new PageResult(pageStu.getTotal(),pageStu.getResult());
    }
}
