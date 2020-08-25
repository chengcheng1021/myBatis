package com.cc.dao;

import com.cc.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccountMapper {

    /**
     * 获取一个账户
     * @param id
     * @return
     */
    @Select("select * from account where ID = #{aid}")
    Account getAccount(@Param("aid") int id);
}
