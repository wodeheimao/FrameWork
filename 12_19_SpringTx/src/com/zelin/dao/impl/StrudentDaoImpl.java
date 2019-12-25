package com.zelin.dao.impl;

import com.zelin.dao.StudentDao;
import com.zelin.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class StrudentDaoImpl implements StudentDao ,RowMapper<Student> {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询所有学生
    @Override
    public List<Student> findAll() {
        String sql = "select st.*,cname from student st ,classes c where c.cid = st.cid ";
        return jdbcTemplate.query(sql,this);
    }

    //根据id查询对单个学生
    @Override
    public Student findSudent(int sid) {
        String sql = "select st.*,cname from student st ,classes c where c.cid = st.cid and sid = ? ";
        return jdbcTemplate.queryForObject(sql,this,sid);
    }

    //删除一个学生
    @Override
    public void deleteStudent(int sid) {
        String sql = "delete from student where sid = ? ";
        jdbcTemplate.update(sql,sid);
    }

    //更新某一学生
    @Override
    public void addStudent(Student student) {
        String sql = "insert into student value (null,?,?,?,?,?)";
        jdbcTemplate.update(sql,student.getSname(),student.getSex(),student.getAge(),student.getAddr(),student.getCid());
    }

    @Override
    public void updateSudent(Student student) {
        String sql = "update student set sname=?, sex=?, age=?, addr=?, cid=? where sid=?";
        jdbcTemplate.update(sql,student.getSname(),student.getSex(),student.getAge(),student.getAddr(),student.getCid(),student.getSid());
    }

    @Override
    public Long findCount() {
        String sql = "select count(*) from student st ,classes c where c.cid = st.cid";
        return jdbcTemplate.queryForObject(sql, (RowMapper<Long>) new RowMapper<Long> () {

            @Override
            public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong(1);
            }
        });
    }

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        //获取学生信息
        int sid  = rs.getInt("sid");
        String sname = rs.getString("sname");
        String sex = rs.getString("sex");
        String age = rs.getString("age");
        String addr = rs.getString("addr");
        String cname = rs.getString("cname");
        Student student = new Student(sid,sname,sex,age,addr,cname);
        return student;
    }
}
