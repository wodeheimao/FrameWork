package com.zelin.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zelin.web.pojo.Classes;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.ClassesService;
import com.zelin.web.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/classes")
public class ClassesServlet extends HttpServlet {
    private ClassesService classesService;
    @Override
    public void init() throws ServletException {
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        classesService = wac.getBean(ClassesService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String cmd = req.getParameter("cmd");
        if(null != cmd && !"".equals(cmd)){
            if("list".equals(cmd)){
                list(req,resp);
            }
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<Classes> classList = classesService.findAll();
            String s = JSON.toJSONString(classList);
            resp.getWriter().println(s);
            resp.getWriter().flush();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
