package com.cc.dao;

import com.cc.pojo.User;
import com.cc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        //方式二：
        //List<User> userList = sqlSession.selectList("com.cc.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭 sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user= userMapper.getUserById(41);

        System.out.println(user);

        //关闭 sqlSession
        sqlSession.close();
    }

    @Test
    public void addUser() {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.addUser(new User(4, "哈哈", "12333333"));
        if (res > 0) {
            System.out.println("插入成功");
        }

        //提交事务
        sqlSession.commit();

        //关闭 sqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.updateUser(new User(4, "哈哈2", "333211111"));
        System.out.println(res);
        if (res > 0) {
            System.out.println("更新成功");
        }

        //提交事务
        sqlSession.commit();

        //关闭 sqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.deleteUser(4);
        System.out.println(res);
        if (res > 0) {
            System.out.println("删除成功");
        }

        //提交事务
        sqlSession.commit();

        //关闭 sqlSession
        sqlSession.close();
    }
}
