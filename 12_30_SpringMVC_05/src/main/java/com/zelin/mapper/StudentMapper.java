package com.zelin.mapper;

import com.zelin.pojo.Student;
import com.zelin.pojo.StudentExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StudentMapper extends Mapper<Student> {

}