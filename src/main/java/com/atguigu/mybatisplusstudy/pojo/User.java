package com.atguigu.mybatisplusstudy.pojo;

import com.atguigu.mybatisplusstudy.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-0:40
 */
@Data
//@TableName("t_user")
public class User {


    //type = IdType.AUTO 设置主键自增 也可以通过配置文件全局设置
//    @TableId(value = "uid",type = IdType.AUTO)//将此字段指定为主键
    //value用来指定主键的字段
    @TableId(value = "uid")
    private Long id;

    @TableField("user_name")//指定属性所对应的字段
    private String name;

    private Integer age;

    private String email;

    @TableLogic//逻辑删除
    private Integer isDeleted;

    private SexEnum sex;


}
