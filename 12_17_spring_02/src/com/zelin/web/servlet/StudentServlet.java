package com.zelin.web.servlet;
import com.alibaba.fastjson.JSON;
import com.zelin.web.pojo.ResultMessage;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.sun.javafx.fxml.expression.Expression.add;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        studentService = wac.getBean(StudentService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String cmd = req.getParameter("cmd");
        if(null != cmd && !"".equals(cmd)){
            if("list".equals(cmd)){
                list(req,resp);
            }else if("addStudent".equals(cmd)){
                addStudent(req,resp);
            }else if("updateStudent".equals(cmd)){
                updateStudent(req,resp);
            }else if("deleteStudent".equals(cmd)){
                deleteStudent(req,resp);
            }
        }
    }


    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<Student> studentList = studentService.findAll();
            String s = JSON.toJSONString(studentList);
            resp.getWriter().println(s);
            resp.getWriter().flush();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    添加学生
    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sname = req.getParameter("sname");
        String age = req.getParameter("age");
        String addr = req.getParameter("addr");
        String sex = req.getParameter("sex");
        String cid = req.getParameter("cid");
        Student student = new Student(sname,sex, age,addr,cid);
        ResultMessage message = null;
        try {
            studentService.addStudent(student);
            message = new ResultMessage(true,"添加成功");
        } catch (SQLException e) {
            e.printStackTrace();
            message = new ResultMessage(false,"添加失败");
        }
        String s = JSON.toJSONString(message);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }

    //更新学生
    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String age = req.getParameter("age");
        String addr = req.getParameter("addr");
        String sex = req.getParameter("sex");
        String cid = req.getParameter("cid");
        Student student = new Student(new Integer(sid),sname,sex, age,addr,cid);
        ResultMessage message = null;
        try {
            studentService.updateStudent(student);
            message = new ResultMessage(true,"修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
            message = new ResultMessage(false,"修改失败");
        }
        String s = JSON.toJSONString(message);
        resp.getWriter().println(s);
        resp.getWriter().flush();

    }

//    删除学生
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sid = req.getParameter("sid");
        ResultMessage message = null;
        try {
            studentService.deleteStudent(sid);
            message = new ResultMessage(true,"删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
            message = new ResultMessage(false,"删除失败");
        }
        String s = JSON.toJSONString(message);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
}
