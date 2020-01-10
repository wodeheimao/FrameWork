package com.zelin.controller;

import com.zelin.pojo.Classes;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/list")
    public List<Classes> list(){
        return classesService.list();
    }
}
