package com.cc.dao;

import com.cc.pojo.User;
import com.cc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class UserDaoTest {


    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (User user : mapper.getUsers()) {
            System.out.println(user);
        }
    }
}
