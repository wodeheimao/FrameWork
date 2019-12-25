package com.zelin.service.impl;


import com.zelin.dao.ClassesDao;
import com.zelin.pojo.Classes;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public void addClasses(Classes classes) {
        classesDao.addClasses(classes);
    }
}
