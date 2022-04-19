package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.mapper.UserMapper;
import com.atguigu.mybatisplusstudy.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-0:53
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1(){
        List<User> list = userMapper.selectList(null);
        list.forEach(x-> System.out.println(x));
    }
    @Test
    public void test2(){
        User user = new User();
        user.setName("zcj");
        user.setAge(12);
        user.setEmail("123.com");
        int i = userMapper.insert(user);
        System.out.println(i);
    }
    @Test
    public void test3(){
//        userMapper.deleteById(1516104703799226369L);

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name","Jone");
//        map.put("age",18);
//        userMapper.deleteByMap(map);

//        List<Integer> list = Arrays.asList(5, 6);
//        userMapper.deleteBatchIds(list);

        userMapper.delete(new QueryWrapper<User>().eq("user_name","jack"));
    }

    @Test
    public void test4(){
        User user = new User();
        user.setId(3l);
        user.setName("修改");
        userMapper.updateById(user);
    }

    @Test
    public void test5(){
        Map<String, Object> map = userMapper.findUserByIdToMap(3l);
        System.out.println(map);
    }




}
