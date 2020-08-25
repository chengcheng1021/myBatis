package com.cc.dao;

import com.cc.pojo.Member;

public interface MemberMapper {

    /**
     * 插入数据
     * @param member
     * @return
     */
    int addMember(Member member);
}
