package com.cc.dao;

import com.cc.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.cc.dao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY)),
    })
    List<User> findAll();

    /**
     * 根据 id 查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);

    /**
     * 根据用户模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);
}
