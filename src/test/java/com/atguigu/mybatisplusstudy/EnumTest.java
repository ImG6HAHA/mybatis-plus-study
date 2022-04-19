package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.enums.SexEnum;
import com.atguigu.mybatisplusstudy.mapper.UserMapper;
import com.atguigu.mybatisplusstudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-20-0:22
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1(){
        User user = new User();
        user.setName("男test");
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
    }



}
