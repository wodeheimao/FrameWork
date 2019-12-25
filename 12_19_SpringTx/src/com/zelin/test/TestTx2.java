package com.zelin.test;

import com.zelin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class TestTx2 {
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
