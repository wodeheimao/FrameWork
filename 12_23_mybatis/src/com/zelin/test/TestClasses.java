package com.zelin.test;

import com.zelin.pojo.Classes;
import com.zelin.pojo.IdCard;
import com.zelin.pojo.Student;
import com.zelin.service.ClassesService;
import com.zelin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-mybatis.xml")
public class TestClasses {

    @Autowired
    private ClassesService classesService;

    @Test
    public void test01(){
      //查询班级(使用自定义ResultMap完成)
      List<Classes> classList =  classesService.findAllClasses();
        for (Classes classes : classList) {
            System.out.println(classes);
            for (Student student : classes.getStudentList()) {
                System.out.println(student);
            }
            System.out.println("----------------------------------------");
        }

    }

    //查询所有班级(使用关联查询完成)
    @Test
    public void test02(){
        //查询班级
        List<Classes> classList =  classesService.findAllClasses2();
        for (Classes classes : classList) {
            System.out.println(classes);
            for (Student student : classes.getStudentList()) {
                System.out.println(student);
            }
            System.out.println("----------------------------------------");
        }
    }

}
