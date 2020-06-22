package com.cc.dao;

import com.cc.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 在 mybatis 中针对，CRUD 一共有4个注解。首字母大写
 * @SELECT
 * @INSERT
 * @UPDATE
 * @DELETE
 */
public class IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
