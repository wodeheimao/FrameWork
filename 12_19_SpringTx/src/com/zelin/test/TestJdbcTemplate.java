package com.zelin.test;

import com.zelin.pojo.Classes;
import com.zelin.pojo.Student;
import com.zelin.service.ClassesService;
import com.zelin.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJdbcTemplate {

    @Autowired
    private ClassesService classesService;
    @Autowired
    private StudentService studentService;

    //查询所有学生
    @Test
    public void TestFindAll() {
        List<Student> studentList = studentService.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    //根据id查询单个学生
    @Test
    public void TestFindSudent() {
        int sid = 1;
        Student student = studentService.findSudent(sid);
        System.out.println(student);
    }
    //根据id删除学生
    @Test
    public void TestDeleteSudent() {
        int sid = 17;
        studentService.deleteSudent(sid);
        System.out.println("删除成功");
    }
    //添加学生
    @Test
    public void TestAddSudent() {
        Student student = new Student("李思","男","23","北京","3");
        studentService.addSudent(student);
        System.out.println("添加成功");
    }
    //修改学生
    @Test
    public void TestUpdateSudent() {
        Student student = new Student(18,"李思2","男","23","北京2","2");
        studentService.updateSudent(student);
        System.out.println("修改成功");
    }
    //查询学生总数
    @Test
    public void TestFindCount() {
        Long count = studentService.findCount();
        System.out.println("count = " + count);
    }

    //添加一个班级
    @Test
    public void TestAddClasses() {
        Classes classes = new Classes();
        classes.setCname("Java13_x");
        classesService.addClasses(classes);
        System.out.println("添加成功");
    }
}
