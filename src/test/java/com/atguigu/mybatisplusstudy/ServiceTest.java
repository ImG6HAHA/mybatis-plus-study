package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.pojo.User;
import com.atguigu.mybatisplusstudy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-1:52
 */

@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        long count = userService.count();//查询总记录数 SELECT COUNT( * ) FROM user
        System.out.println(count);


    }

    @Test
    public void test2(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("zcj"+i);
            user.setAge(11+i);
            list.add(user);
        }
        userService.saveBatch(list);//批量添加


    }



}
