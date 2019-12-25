package com.bm.web.dao;

import com.bm.web.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao , RowMapper<Book> {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询所有图书
    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql,this);
    }

    //删除
    @Override
    public void deleteBook(String bno) {
        jdbcTemplate.update("delete from book where bno = ?",bno);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update book set bname=?,author=?,publisher=?, yprice=? where bno= ?";
        jdbcTemplate.update(sql,book.getBname(),book.getAuthor(),book.getPublisher(),book.getYprice(),book.getBno());
    }

    @Override
    public void addBook(Book book) {
        String sql = "insert into book (bno,bname,author,publisher,yprice) value (null,?,?,?,?)";
        jdbcTemplate.update(sql,book.getBno(),book.getBname(),book.getAuthor(),book.getPublisher(),book.getYprice());
    }

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book book = new Book(rs.getString("bno"),rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7));
        return book;
    }
}
