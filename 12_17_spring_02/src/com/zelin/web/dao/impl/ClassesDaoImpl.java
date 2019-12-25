package com.zelin.web.dao.impl;
import	java.beans.BeanDescriptor;

import com.zelin.web.dao.ClassesDao;
import com.zelin.web.pojo.Classes;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ClassesDaoImpl implements ClassesDao {
    @Autowired
    private QueryRunner qr;

    @Override
    public List<Classes> findAll() throws SQLException {
        return qr.query("select * from classes",new BeanListHandler<>(Classes.class));
    }
}
