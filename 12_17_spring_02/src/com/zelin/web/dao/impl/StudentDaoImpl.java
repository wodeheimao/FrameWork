package com.zelin.web.dao.impl;

import com.zelin.web.dao.StudentDao;
import com.zelin.web.pojo.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private QueryRunner qr;
    //查询所有学生
    @Override
    public List<Student> findAll() throws SQLException {
        String sql = "select * from student st, classes c where st.cid = c.cid";
        return qr.query(sql, new BeanListHandler<>(Student.class));
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "insert into student values (null,?,?,?,?,?)";
        qr.update(sql,student.getSname(),student.getSex(),student.getAge(),student.getAddr(),student.getCid());
    }

    @Override
    public Student findStudentBySid(String sid) throws SQLException {
        String sql = "select * from student st, classes c where st.cid = c.cid and sid =?";
        return qr.query(sql, new BeanHandler<>(Student.class),sid);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String sql = "update student set sname=?, sex=?,age=?,addr=?,cid=? where sid=?";
        qr.update(sql,student.getSname(),student.getSex(),student.getAge(),student.getAddr(),student.getCid(),student.getSid());
    }

    @Override
    public void deleteStudent(String sid) throws SQLException {
        String sql = "delete from student where sid = ?";
        qr.update(sql,sid);
    }
}
