package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.mapper.UserMapper;
import com.atguigu.mybatisplusstudy.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-22:31
 * 分页插件测试
 */
@SpringBootTest
public class PluginsTest {

    @Autowired
    private UserMapper userMapper;


    @Test//current 当前页码
    public void test1(){
        Page<User> page = new Page<>(3,3);

        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage);

    }

    @Test//自定义方法分页
    public void test2(){
        Page<User> page = new Page<>(3,3);
        Page<User> userPage = userMapper.selectPageByAge(page,12);

        System.out.println(userPage);

    }

}
