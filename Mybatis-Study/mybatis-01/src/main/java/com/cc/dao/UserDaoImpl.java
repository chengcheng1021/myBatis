package com.cc.dao;

import com.cc.pojo.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public List<User> getUserList() {
        //执行SQL
        String sql = "select * from mybatis.user";
        //结果集ResultSet
        return null;
    }
}
