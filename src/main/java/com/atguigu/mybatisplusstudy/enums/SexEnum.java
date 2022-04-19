package com.atguigu.mybatisplusstudy.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-20-0:17
 */
@Getter
public  enum SexEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue//将注解所标识的属性值存到数据库中 需要在配置文件配置
    private Integer sex;


    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
