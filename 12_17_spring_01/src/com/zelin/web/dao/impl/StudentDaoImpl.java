package com.zelin.web.dao.impl;

import com.zelin.web.dao.StudentDao;
import com.zelin.web.pojo.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    //查询所有学生
    @Override
    public List<Student> findAll() throws SQLException {
        return qr.query("select * from student", new BeanListHandler<>(Student.class));
    }
}
