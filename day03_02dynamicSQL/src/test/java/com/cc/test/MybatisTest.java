package com.cc.test;

import com.cc.dao.IUserDao;
import com.cc.domain.QueryVo;
import com.cc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试 Mybatis 的 CRUD 操作
 */
public class MybatisTest {

    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法之前执行
    public void init() throws IOException {
        //1、读取配置文件，生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2、获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3、获取SqlSession对象
        sqlSession = factory.openSession();

        //4、获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法之后执行
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();
        //6、释放资源
        sqlSession.close();
        is.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws IOException {
        //5、执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFindById() {
        //5、执行保存方法
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 测试根据用户名称查询用户
     */
    @Test
    public void testFindByName() {
        //5、执行保存方法
//        List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据用户名称查询用户
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        //5、执行保存方法
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 测试 where 标签的使用
     */
    @Test
    public void testFindByCondition() throws IOException {
        User u = new User();
        u.setUserName("老王");
        u.setUserSex("女");

        //5、执行查询所有方法
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试 foreach 标签的使用
     */
    @Test
    public void testFindInIds() throws IOException {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        vo.setIds(list);

        //5、执行查询所有方法
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
