package com.zelin.service.impl.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Classes;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentExample;
import com.zelin.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;

    //分页条件查询
    @Override
    public PageResult search(Integer page, Integer pageSize, Student student) {
        //开始分页
        PageHelper.startPage(page,pageSize);
        //建立查询example
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        if (student != null) {
            if(StringUtils.isNotBlank(student.getSname())){
                criteria.andSnameLike("%"+student.getSname()+"%");
            }
            if(StringUtils.isNotEmpty(student.getAddr())){
                criteria.andAddrLike("%"+student.getAddr()+"%");
            }
            if(student.getCid()!=null && student.getCid().intValue()!=0){
                criteria.andCidEqualTo(student.getCid());
            }
        }
        //查询student
        List<Student> studentList = studentMapper.selectByExample(example);
        for (Student student1 : studentList) {
            Classes classes = classesMapper.selectByPrimaryKey(student1.getCid());
            student1.setCname(classes.getCname());
        }
        Page<Student> studentPage = (Page<Student>) studentList;
        return new PageResult(studentPage.getTotal(),studentPage.getResult());
    }

    //添加学生
    @Override
    public void addStu(Student student) {
        studentMapper.insert(student);
    }

    //删除学生
    @Override
    public void deleteStu(String sid) {
        studentMapper.deleteByPrimaryKey(new Integer(sid));
    }
    //修改学生
    @Override
    public void updateStu(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }
}
