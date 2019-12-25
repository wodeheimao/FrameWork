package com.zelin.web.service.impl;

import com.zelin.web.mapper.ClassesMapper;
import com.zelin.web.mapper.StudentMapper;
import com.zelin.web.pojo.Classes;
import com.zelin.web.pojo.Student;
import com.zelin.web.service.ClassesService;
import com.zelin.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> findAll() {
        return classesMapper.findAll();
    }
}
