package com.zelin.web.dao;

import com.zelin.web.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    List<Student> findAll() throws SQLException;
}
