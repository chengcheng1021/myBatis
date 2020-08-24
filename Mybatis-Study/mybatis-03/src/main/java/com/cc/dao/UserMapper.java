package com.cc.dao;

import com.cc.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(int id);
}
