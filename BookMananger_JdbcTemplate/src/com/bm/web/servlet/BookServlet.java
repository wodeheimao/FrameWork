package com.bm.web.servlet;
import	java.sql.ResultSet;

import com.alibaba.fastjson.JSON;
import com.bm.web.pojo.Book;
import com.bm.web.pojo.ResultMessage;
import com.bm.web.service.BookService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService ;

    @Override
    public void init() throws ServletException {
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        bookService = wac.getBean(BookService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String cmd = req.getParameter("cmd");
        System.out.println("cmd = " + cmd);
        if(null != cmd && !"".equals(cmd)){
            if("list".equals(cmd)){             //列表显示
                list(req,resp);
            }else if("add".equals(cmd)){            //添加
                addBook(req,resp);
            }else if("delete".equals(cmd)){         //删除
                deleteBook(req,resp);
            }else if("update".equals(cmd)){         //修改
                updateBook(req,resp);
            }
        }
    }

    //查询所有图书
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(" -------------- ");
        List<Book> books = bookService.findAll();
        //转化为json字符串
        String s = JSON.toJSONString(books);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }


    //添加图书
    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bno = req.getParameter("bno");
        String bname = req.getParameter("bname");
        String author = req.getParameter("author");
        String publisger = req.getParameter("publisger");
        String yprice = req.getParameter("yprice");
        Book book = new Book(bno,bname,author,publisger,yprice);
        bookService.addBook(book);
        ResultMessage rsm = new ResultMessage(true,"成功");
        //转化为json字符串
        String s = JSON.toJSONString(rsm);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
    //修改图书
    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bno = req.getParameter("bno");
        String bname = req.getParameter("bname");
        String author = req.getParameter("author");
        String publisger = req.getParameter("publisger");
        String yprice = req.getParameter("yprice");
        Book book = new Book(bno,bname,author,publisger,yprice);
        bookService.updateBook(book);
        ResultMessage rsm = new ResultMessage(true,"成功");
        //转化为json字符串
        String s = JSON.toJSONString(rsm);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }
    //添加图书
    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bno = req.getParameter("bno");
        bookService.deleteBook(bno);
        ResultMessage rsm = new ResultMessage(true,"成功");
        //转化为json字符串
        String s = JSON.toJSONString(rsm);
        resp.getWriter().println(s);
        resp.getWriter().flush();
    }


}










