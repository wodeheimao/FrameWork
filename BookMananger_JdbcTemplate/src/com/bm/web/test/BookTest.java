package com.bm.web.test;

import com.bm.web.pojo.Book;
import com.bm.web.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookTest {
    @Autowired
    private BookService bookService;

    @Test
    public void test01() {
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            System.out.println("book = " + book);
        }
    }
}
