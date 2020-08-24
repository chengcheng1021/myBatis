package com.cc.dao;

import com.cc.pojo.User;
import com.cc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test() {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(41);

        //方式二：
        //List<User> userList = sqlSession.selectList("com.cc.dao.UserDao.getUserList");

        System.out.println(user);

        //关闭 sqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j方法");
        logger.info("debug:进入了testLog4j方法");
        logger.info("error:进入了testLog4j方法");

    }
}
