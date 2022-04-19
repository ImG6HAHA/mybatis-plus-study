package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.service.ProductService;
import com.atguigu.mybatisplusstudy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-20-1:00
 */
@SpringBootTest
public class DatasourceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
