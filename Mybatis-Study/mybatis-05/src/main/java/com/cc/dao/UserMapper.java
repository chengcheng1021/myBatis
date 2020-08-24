package com.cc.dao;

import com.cc.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    /**
     * 获取所有用户
     * @return
     */
    @Select("select * from user")
    List<User> getUsers();
}
