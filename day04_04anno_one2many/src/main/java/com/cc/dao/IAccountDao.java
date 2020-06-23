package com.cc.dao;

import com.cc.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();
}
