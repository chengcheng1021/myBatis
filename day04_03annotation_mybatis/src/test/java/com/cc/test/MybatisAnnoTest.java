package com.cc.test;

import com.cc.dao.IUserDao;
import com.cc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {

    /**
     * 测试基于注解的 mybatis 使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1、获取字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、根据字节输入流构建 SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3、根据 SqlSessionFactory 生产一个 SqlSession
        SqlSession session = factory.openSession();
        //4、使用 SqlSession 获取 Dao 的代理对象
        IUserDao dao = session.getMapper(IUserDao.class);
        //5、执行 Dao 方法
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6、释放资源
        session.close();
        is.close();
    }
}
