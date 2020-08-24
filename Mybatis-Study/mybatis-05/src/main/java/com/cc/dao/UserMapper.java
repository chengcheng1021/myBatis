package com.cc.dao;

import com.cc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /**
     * 获取所有用户
     * @return
     */
    @Select("select * from user")
    List<User> getUsers();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    /**
     * 插入用户
     * @param user
     * @return
     */
    @Insert("insert into mybatis.user(id,username,pwd) values (#{id}, #{username}, #{password})")
    int addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Update("update mybatis.user set username=#{username},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from mybatis.user where id=#{id}")
    int deleteUser(int id);
}
