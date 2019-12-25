package com.zelin.web.service.impl;
import	java.awt.Desktop.Action;

import com.zelin.web.dao.ClassesDao;
import com.zelin.web.pojo.Classes;
import com.zelin.web.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesDao classesDao;
    @Override
    public List<Classes> findAll() throws SQLException {
        return classesDao.findAll();
    }
}
