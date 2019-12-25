package com.zelin.service.impl;

import com.zelin.dao.StudentDao;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    //查询所有学生
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    //查询某一学生
    @Override
    public Student findSudent(int sid) {
        return studentDao.findSudent(sid);
    }

    //删除某一学生
    @Override
    public void deleteSudent(int sid) {
        studentDao.deleteStudent(sid);
    }

    //添加学生
    @Override
    public void addSudent(Student student) {
        studentDao.addStudent(student);
    }

    //修改学生
    @Override
    public void updateSudent(Student student) {
        studentDao.updateSudent(student);
    }

    //求学生总数
    @Override
    public Long findCount() {
        return studentDao.findCount();
    }
}
