package com.bm.web.service;

import com.bm.web.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void deleteBook(String bno);

    void addBook(Book book);

    void updateBook(Book book);
}
