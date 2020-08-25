package com.cc.dao;

import com.cc.pojo.Account;
import com.cc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 获取所有学生
     * @return
     */
    List<User> getUsers();

    /**
     * 获取指定用户下的信息和账户
     * @param id
     * @return
     */
    User getUsers2(@Param("uid") int id);

    /**
     *
     * @param id
     * @return
     */
    User getUsers3(@Param("uid") int id);
}
