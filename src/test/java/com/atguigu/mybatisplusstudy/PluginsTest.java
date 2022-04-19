package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.mapper.ProductMapper;
import com.atguigu.mybatisplusstudy.mapper.UserMapper;
import com.atguigu.mybatisplusstudy.pojo.Product;
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
    @Autowired
    private ProductMapper productMapper;


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

    @Test//乐观锁解决修改价格冲突
    public void testConcurrentUpdate(){
        //小李查询价格
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格：" + p1.getPrice());
        //小王查询价格
        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格：" + p2.getPrice());
        //小李将商品价格+50
        p1.setPrice(p1.getPrice()+50);
        productMapper.updateById(p1);
        //小王将价格-30
        p2.setPrice(p2.getPrice()-30);
        int result = productMapper.updateById(p2);
        if (result==0){
            //操作失败 重试
            Product productNew = productMapper.selectById(1L);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        //老板查询价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板查询出的价格：" + p3.getPrice());

    }

}
