package com.zelin.web.test;

import com.zelin.web.pojo.Classes;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.ClassesService;
import com.zelin.web.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-mybatis.xml")
public class studentTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;

    //查询所有学生
    @Test
    public void testFindAll() {
        List<Student> students = studentService.findAll();
        //打印学生信息
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void testDelete() {
        studentService.deleteStudent("17");
    }

    @Test
    public void testUpdate() {
        Student student = new Student(17,"bbb","男","12","bbb","3");
        studentService.updateStudent(student);
    }

    @Test
    public void testAdd() {
        Student student = new Student("aaa","男","12","aaa","2");
        studentService.addStudent(student);
    }
    @Test
    public void testClassFindAll() {
        List<Classes>  classesList= classesService.findAll();
        //打印学生信息
        for (Classes c : classesList) {
            System.out.println("c = " + c);
        }
    }
}
