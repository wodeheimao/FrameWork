package com.zelin.service;

import com.zelin.pojo.*;

import java.util.List;

public interface StudentService {
    //根据关键字查询学生列表
    List<Student> findStudentsByKeywords(StudentVo studentVo);
    //根据学生查询查询学生列表
    List<Student> findStudentsBySids(StudentVo studentVo);
    //根据关键字及id号一起查询
    List<Student> findStudentsByKeywords2(StudentVo studentVo);
}
