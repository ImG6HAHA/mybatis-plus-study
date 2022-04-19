package com.atguigu.mybatisplusstudy.service.impl;

import com.atguigu.mybatisplusstudy.mapper.ProductMapper;
import com.atguigu.mybatisplusstudy.pojo.Product;
import com.atguigu.mybatisplusstudy.service.ProductService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-20-0:58
 */
@Service
@DS("slave_1")//slave_1数据源
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
