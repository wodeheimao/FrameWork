package com.zelin.test;

import com.zelin.pojo.User;
import com.zelin.pojo.UsersCustom;
import com.zelin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-mybatis.xml")
public class TestUser {

    @Autowired
    private UserService userService;

    //查询所有用户(自定义实体类)
    @Test
    public void test01(){
        //查询所有用户
       List<UsersCustom> usersCustoms =  userService.findAllUsers();
       //遍历用户
        for (UsersCustom usersCustom : usersCustoms) {
            System.out.println(usersCustom);
        }
    }

    //查询所有用户(使用映射结果集)
    @Test
    public void test02(){
        //查询所有用户
        List<User> users =  userService.findAllUsers2();
        //遍历用户
        for (User user : users) {
            System.out.println(user+"---"+user.getIdCard());
        }
    }
    //查询所有用户(使用懒加载)
    @Test
    public void test03(){
        //查询所有用户
        List<User> users =  userService.findAllUsers3();
        //遍历用户
        for (User user : users) {
            System.out.println(user+"---"+user.getIdCard());
        }
    }


    @Test
    public void demo() {
        HashMap<String, String> map = new HashMap<>(4);
        map.put("aa","1");
        map.put("bb","2");
        map.put("cc","3");
        map.put("dd","1");

    }
}
