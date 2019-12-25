package com.zelin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zelin.web.pojo.ResultMsg;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext wacp = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        studentService = wacp.getBean(StudentService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String cmd = req.getParameter("cmd");
        System.out.println("cmd = " + cmd);
        if(null != cmd && !"".equals(cmd)){
            if("list".equals(cmd)){
                list(req,resp);
            }else if("add".equals(cmd)){
                add(req,resp);
            }else if("update".equals(cmd)){
                update(req,resp);
            }else if("delete".equals(cmd)){
                delete(req,resp);
            }
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Student> studentList = studentService.findAll();
        String s = JSON.toJSONString(studentList);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sname = req.getParameter("sname");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String addr = req.getParameter("addr");
        String cid = req.getParameter("cid");
        Student student = new Student(sname,sex,age,addr,cid);
        studentService.addStudent(student);
        ResultMsg rs = new ResultMsg(true,"添加成功");
        String s = JSON.toJSONString(rs);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String addr = req.getParameter("addr");
        String cid = req.getParameter("cid");
        Student student = new Student(Integer.parseInt(sid),sname,sex,age,addr,cid);
        studentService.updateStudent(student);
        ResultMsg rs = new ResultMsg(true,"更新成功");
        String s = JSON.toJSONString(rs);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sid = req.getParameter("sid");
        System.out.println("sid = " + sid);
        studentService.deleteStudent(sid);
        ResultMsg rs = new ResultMsg(true,"删除成功");
        String s = JSON.toJSONString(rs);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
}
