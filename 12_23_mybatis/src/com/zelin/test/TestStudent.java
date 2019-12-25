package com.zelin.test;

import com.zelin.pojo.Classes;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo;
import com.zelin.service.ClassesService;
import com.zelin.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-mybatis.xml")
public class TestStudent {

    @Autowired
    private StudentService studentService;

    @Test
    public void test01(){
        StudentVo studentVo = new StudentVo();
        studentVo.setAddr("上");
        studentVo.setSname("三");
        studentVo.setSid(14);
        List<Student> students = studentService.findStudentsByKeywords(studentVo);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test02(){
        StudentVo studentVo = new StudentVo();
        studentVo.setSids(new int[]{14,1,2,3});
        List<Student> students = studentService.findStudentsBySids(studentVo);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    //根据关键字及id号一起查询
    @Test
    public void test03(){
        //得到studentVo类
        StudentVo studentVo = new StudentVo();
        studentVo.setAddr("上");
        studentVo.setSname("三");
        studentVo.setSids(new int[]{14,11});
        //查询学生
        List<Student> students = studentService.findStudentsByKeywords2(studentVo);
        //遍历
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
