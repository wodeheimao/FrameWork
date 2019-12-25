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
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClassesMapper classesMapper;

    //查询全部学生
    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentMapper.selectByExample(null);
        for (Student student : studentList) {
            Classes classes = classesMapper.selectByPrimaryKey(student.getCid());
            student.setCname(classes.getCname());
        }
        return studentList;
    }

    //分页查询全部学生
    @Override
    public PageResult<Student> pageList(int page) {
        int pageSize = 3;
        //开始分页
        PageHelper.startPage(page, pageSize);
        //定义查询辅助类
        StudentExample example = new StudentExample();
        //开始查询
        List<Student> studentList = studentMapper.selectByExample(example);
        //将插到的classes 中cname赋值给student
        for (Student student : studentList) {
            Classes classes = classesMapper.selectByPrimaryKey(student.getCid());
            student.setCname(classes.getCname());
        }
        //装换为Page
        Page<Student> pageStu = (Page<Student>) studentList;
        System.out.println("pageStu = " + pageStu);
        return new PageResult<Student>(pageStu.getTotal(), pageStu.getResult(), page, pageStu.getPages());
    }

    //分页条件查询所有学生
    @Override
    public PageResult<Student> searchPage(Student student, int page) {
        int pageSize = 3;
        //开始分页
        PageHelper.startPage(page, pageSize);
        //定义查询辅助类
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        if (null != student) {
            if (!StringUtils.isEmpty(student.getAddr())) {
                criteria.andAddrLike("%" + student.getAddr() + "%");
            }
            if (!StringUtils.isEmpty(student.getSname())) {
                criteria.andSnameLike("%" + student.getSname() + "%");
            }
            if (student.getCid()!=null && 0 != student.getCid().intValue()) {
                criteria.andCidEqualTo(student.getCid());
            }
        }
        System.out.println("student = " + student);
        //开始查询
        List<Student> studentList = studentMapper.selectByExample(example);
        //将插到的classes 中cname赋值给student
        for (Student stu : studentList) {
            Classes classes = classesMapper.selectByPrimaryKey(stu.getCid());
            stu.setCname(classes.getCname());
        }
        //装换为Page
        Page<Student> pageStu = (Page<Student>) studentList;
        System.out.println("pageStu = " + pageStu);
        return new PageResult<Student>(pageStu.getTotal(), pageStu.getResult(), page, pageStu.getPages());
    }

}
