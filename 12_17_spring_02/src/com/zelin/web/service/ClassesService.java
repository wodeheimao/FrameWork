package com.zelin.web.service;

import com.zelin.web.pojo.Classes;

import java.sql.SQLException;
import java.util.List;

public interface ClassesService {
    List<Classes> findAll() throws SQLException;
}
