package com.cc.dao;

import com.cc.pojo.Account;
import com.cc.pojo.User;
import com.cc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class UserDaoTest {


    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.getAccount(1);
        System.out.println(account);
    }
}
