package com.cc.dao;

import com.cc.domain.QueryVo;
import com.cc.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户
     * @param userName
     * @return
     */
    List<User> findByName(String userName);

    /**
     * 根据 queryVo 中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件：有可能有用户名，有可能有。。。。
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据 queryvo 中提供的 id 集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
