package com.zelin.service.impl.impl;

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

    //查询班级
    @Override
    public List<Classes> list() {
        return classesMapper.selectAll();
    }
}
