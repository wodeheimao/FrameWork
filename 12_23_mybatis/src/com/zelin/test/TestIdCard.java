package com.zelin.test;

import com.zelin.pojo.IdCard;
import com.zelin.pojo.User;
import com.zelin.pojo.UsersCustom;
import com.zelin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-mybatis.xml")
public class TestIdCard {

    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        //查询idcard
       IdCard idCard =  userService.findIdCardById(1);
       //打印idcard
        System.out.println(idCard+"-------"+idCard.getUser());
    }


}
