package com.zelin.web.controller;
import	java.util.Queue;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController         //等于@Controller + @ResponseBody
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;



    //查询所有学生
    @RequestMapping("list")
    @ResponseBody
    public List<Student> findAll(){
        return studentService.findAll();
    }
    //分页查询所有学生
    @RequestMapping("pageList")
    public PageResult pageList(int page, int pageSize){
        return studentService.pageList(page,pageSize);
    }
}
