package com.atguigu.mybatisplusstudy;

import com.atguigu.mybatisplusstudy.mapper.UserMapper;
import com.atguigu.mybatisplusstudy.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-19-19:43
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1(){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name","a").between("age",20,30).isNotNull("email");

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(x-> System.out.println(x));
    }

    @Test
    public void test2(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        //按年龄降序排列 年龄相同按uid升序排列
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age").
        orderByAsc("uid");

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(x-> System.out.println(x));
    }

    @Test
    public void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");

        userMapper.delete(wrapper);
    }

    @Test//修改 UPDATE t_user SET user_name=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
    public void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age",20).like("user_name","a").
                or().isNull("email");


        User user = new User();
        user.setName("小米修改");

        userMapper.update(user,wrapper);
    }

    @Test//条件优先级
    public void test5(){// UPDATE t_user SET user_name=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name","a").and(w->w.gt("age",20).or().isNull("email"));



        User user = new User();
        user.setName("小hong");

        userMapper.update(user,wrapper);
    }

    //查询指定字段
    @Test
    public void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_name","age","email");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
    }

    //子查询 SELECT * FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid<6))
    @Test
    public void test7(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("uid","select uid from t_user where uid<6");

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(x-> System.out.println(x));
    }

    @Test//UpdateWrapper 更新
    public void test8(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.like("user_name","a").and(w->w.gt("age",20).or().isNull("email"));
        wrapper.set("user_name","孙笑川").set("age",123);

        userMapper.update(null,wrapper);
    }

    //判断--条件组装
    @Test
    public void test9(){
        String userName="a";
        Integer ageBegin=null;
        Integer ageEnd=30;

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(userName)){
            wrapper.like("user_name",userName);
        }
        if (ageBegin!=null){
            wrapper.ge("age",ageBegin);
        }
        if (ageEnd!=null){
            wrapper.le("age",ageEnd);
        }

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(x-> System.out.println(x));
    }

    @Test//优化上面的写法
    public void test10(){
        String userName="a";
        Integer ageBegin=null;
        Integer ageEnd=30;

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(userName),"user_name",userName)
                .ge(ageBegin!=null,"age",ageBegin).le(ageEnd!=null,"age",ageEnd);

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(x-> System.out.println(x));
    }

    @Test//LambdaQueryWrapper 可以直接get字段
    public void test11(){
        String userName="a";
        Integer ageBegin=null;
        Integer ageEnd=30;

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(userName),User::getName,userName)
                .ge(ageBegin!=null,User::getAge,ageBegin).le(ageEnd!=null,User::getAge,ageEnd);

        List<User> list = userMapper.selectList(wrapper);
        list.forEach(x-> System.out.println(x));
    }

    @Test//LambdaUpdateWrapper
    public void test12(){
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.like(User::getName,"a").and(w->w.gt(User::getAge,20).or().isNull(User::getEmail));
        wrapper.set(User::getName,"孙笑川").set(User::getAge,123);

        userMapper.update(null,wrapper);
    }
}
