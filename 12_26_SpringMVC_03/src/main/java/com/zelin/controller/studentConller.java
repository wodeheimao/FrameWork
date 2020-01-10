package com.zelin.controller;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Result;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("student")
public class studentConller {
    @Autowired
    private StudentService studentService;

    //条件查询并分页
    @RequestMapping("search")
    public PageResult search(Integer page, Integer pageSize,@RequestBody(required = false) Student student) {
        return studentService.search(page,pageSize,student);
    }

    //添加学生
    @RequestMapping("add")
    public Result addStu(@RequestBody Student student){
        try {
            studentService.addStu(student);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加失败");
        }
    }

    //删除学生
    @RequestMapping("delete")
    public Result deleteStu(String sid){
        try {
            studentService.deleteStu(sid);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除失败");
        }
    }

    //修改学生
    @RequestMapping("update")
    public Result updateStu(@RequestBody Student student){
        try {
            studentService.updateStu(student);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"修改失败");
        }
    }
}
