package com.atguigu.mybatisplusstudy.service.impl;

import com.atguigu.mybatisplusstudy.mapper.UserMapper;
import com.atguigu.mybatisplusstudy.pojo.User;
import com.atguigu.mybatisplusstudy.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-1:50
 */
@Service
@DS("master")//master数据源
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
