package com.zelin.service.impl;

import com.zelin.mapper.ClassesMapper;
import com.zelin.pojo.Classes;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    //查询班级(使用自定义ResultMap完成)
    @Override
    public List<Classes> findAllClasses() {
        return classesMapper.findAllClasses();
    }

    //查询所有班级(使用关联查询完成)
    @Override
    public List<Classes> findAllClasses2() {
        return classesMapper.findAllClasses2();
    }
}
