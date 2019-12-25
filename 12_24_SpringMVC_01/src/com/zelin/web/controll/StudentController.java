package com.zelin.web.controll;

import com.zelin.pojo.Classes;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;
import com.zelin.service.ClassesService;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;

    //查询全部
    @RequestMapping("list")
    public String list(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }


    //分页查询
    @RequestMapping("listPage")
    public String listPage(Model model,Integer page){
        //分页查询
        PageResult<Student> pr = studentService.pageList(page==null ? 1 :page);
        //将结果放入modle中
        model.addAttribute("pr",pr);
        return "student/listPage";
    }

    //分页条件查询
    @RequestMapping("searchPage")
    public String searchPage(Model model,Student student,Integer page){
        PageResult<Student> pr = studentService.searchPage(student,page==null ? 1 :page);
        //将结果放入modle中
        model.addAttribute("pr",pr);
       List<Classes> classes =  classesService.findAll();
       model.addAttribute("classes" ,classes);
       model.addAttribute("student" ,student);
        return "student/searchPage";
    }
}
