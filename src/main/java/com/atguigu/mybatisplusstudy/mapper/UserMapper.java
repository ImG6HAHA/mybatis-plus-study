package com.atguigu.mybatisplusstudy.mapper;

import com.atguigu.mybatisplusstudy.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-0:42
 */

@Repository//标识为持久层组件
public interface UserMapper extends BaseMapper<User> {



    Map<String,Object> findUserByIdToMap(Long id);

    Page<User>  selectPageByAge(@Param("page")Page<User> page ,@Param("age") Integer age );
}
