package com.zelin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping("login")
    public void login(String username,String password) throws ServletException, IOException {
        if("admin".equalsIgnoreCase(password)){
            request.setAttribute("username",username);
            request.getRequestDispatcher("/").forward(request,response);

        }else{
            request.setAttribute("message" , "输入密码有误！！！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
