package com.atguigu.mybatisplusstudy.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-23:49
 */
@Data
public class Product {


    private Long id;

    private String name;

    private Integer price;

    @Version //标识乐观锁版本号字段
    private Integer version;

}

