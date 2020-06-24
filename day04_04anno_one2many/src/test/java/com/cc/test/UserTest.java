package com.cc.test;

import com.cc.dao.IUserDao;
import com.cc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {

    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("------每个用户的信息------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(55);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() {
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
