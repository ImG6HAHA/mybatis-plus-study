package com.atguigu.mybatisplusstudy.mapper;
import java.util.List;

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

    //插件自动生成
    int insertSelective(User user);


    //插件可以智能生成方法
    int deleteByIdAndEmail(@Param("id") Long id, @Param("email") String email);

    int updateAgeAndNameById(@Param("age") Integer age, @Param("name") String name, @Param("id") Long id);



}
