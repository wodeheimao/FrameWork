package com.bm.web.dao;

import com.bm.web.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    void deleteBook(String bno);

    void updateBook(Book book);

    void addBook(Book book);
}
