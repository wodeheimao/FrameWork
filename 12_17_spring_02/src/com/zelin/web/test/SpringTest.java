package com.zelin.web.test;

import com.zelin.web.pojo.Student;
import com.zelin.web.service.StudentService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private QueryRunner qr;
    @Autowired
    private StudentService studentService;

    @Test
    public void test01() throws SQLException {
        List<Student> studentList = studentService.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void test02() throws SQLException {
        List<Student> studentList = qr.query("select * from student", new BeanListHandler<>(Student.class));
        System.out.println("studentList = " + studentList);
    }
}
