package com.zelin.test;

import com.zelin.pojo.Classes;
import com.zelin.pojo.Student;
import com.zelin.service.ClassesService;
import com.zelin.service.StudentService;
import com.zelin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTx {
    @Autowired
    private UserService userService;

    @Test
    public void testTransf(){
        int out =1;
        int in = 2;
        double money = 500;
        userService.transf(out,in,money);
        System.out.println("转账成功");
    }
}
