package com.cc.dao;

import com.cc.pojo.Member;
import com.cc.utils.IDUtils;
import com.cc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

        Member member = new Member();
        member.setId(IDUtils.getId());
        member.setEmail("492245711@qq.com");
        member.setNickname("这是昵称");
        member.setPhoneNum("17512572157");

        mapper.addMember(member);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("nickname","小三");
        List<Member> members = mapper.queryMemberIF(map);
        for (Member member : members) {
            System.out.println(member);
        }
        sqlSession.close();
    }

}
