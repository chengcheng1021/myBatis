package com.cc.dao;

import com.cc.pojo.Account;
import com.cc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    /**
     * 获取一个账户
     * @param id
     * @return
     */
    @Select("select * from account where ID = #{aid}")
    Account getAccount(@Param("aid") int id);

    /**
     * 获取所有账户
     * @return
     */
    List<Account> getAccounts();

    /**
     * 获取用户
     * @param id
     * @return
     */
    User getUser(@Param("id") int id);

    /**
     * 获取用户
     * @return
     */
    List<Account> getAccounts2();
}
