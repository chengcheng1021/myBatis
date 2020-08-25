package com.cc.dao;

import com.cc.pojo.User;
import com.cc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(41);
        System.out.println(user);

        //如果中间有增删改操作，会刷新一级缓存

        //手动清除缓存
        //sqlSession.clearCache();

        User user2 = mapper.queryUserById(41);
        System.out.println(user2);

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(41);
        System.out.println(user);

        User user2 = mapper2.queryUserById(41);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();
        sqlSession2.close();
    }
}
