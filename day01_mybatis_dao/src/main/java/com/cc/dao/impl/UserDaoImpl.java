package com.cc.dao.impl;

import com.cc.dao.IUserDao;
import com.cc.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<User> findAll() {
        //1、使用工厂创建 SqlSession 对象
        SqlSession session = factory.openSession();

        //2、使用 session 执行查询所有方法
        List<User> users = session.selectList("com.cc.dao.IUserDao.findAll");
        session.close();

        return users;
    }
}
