package com.zelin.web.service;

import com.zelin.web.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    List<Student> findAll() throws SQLException;
}
