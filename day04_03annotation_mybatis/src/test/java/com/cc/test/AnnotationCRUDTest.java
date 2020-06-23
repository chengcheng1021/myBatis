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

public class AnnotationCRUDTest {

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
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("南京市鼓楼区");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(56);
        user.setUsername("mybatis annotation");
        user.setAddress("南京市鼓楼区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(56);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(55);
        System.out.println(user);
    }
}
