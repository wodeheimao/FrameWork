package com.zelin.dao.impl;

import com.zelin.dao.ClassesDao;
import com.zelin.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClassesDaoImpl implements ClassesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addClasses(Classes classes) {
        jdbcTemplate.update("insert into classes value (null,?)",classes.getCname());
    }
}
