package com.cc.dao;

import com.cc.pojo.Member;

import java.util.List;
import java.util.Map;

public interface MemberMapper {

    /**
     * 插入数据
     * @param member
     * @return
     */
    int addMember(Member member);

    /**
     * 模糊查询
     * @param map
     * @return
     */
    List<Member> queryMemberIF(Map map);

    /**
     * choose(when otherwise) 查询
     * @param map
     * @return
     */
    List<Member> queryMemberChoose(Map map);

    /**
     * 根据id查询
     * @param map
     * @return
     */
    List<Member> queryMemberForeach(Map map);

}
