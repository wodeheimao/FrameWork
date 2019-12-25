package com.zelin.web.dao;

import com.zelin.web.pojo.Classes;

import java.sql.SQLException;
import java.util.List;

public interface ClassesDao {
    List<Classes> findAll() throws SQLException;
}
