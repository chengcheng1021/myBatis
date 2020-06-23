package com.cc.test;

import com.cc.dao.IAccountDao;
import com.cc.dao.IUserDao;
import com.cc.domain.Account;
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
import java.util.List;

public class AccountTest {

    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
