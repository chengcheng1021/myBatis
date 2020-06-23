package com.cc.dao;

import com.cc.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 在 mybatis 中针对，CRUD 一共有4个注解。首字母大写
 * @SELECT
 * @INSERT
 * @UPDATE
 * @DELETE
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username, address, sex, birthday) values(#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);
}
