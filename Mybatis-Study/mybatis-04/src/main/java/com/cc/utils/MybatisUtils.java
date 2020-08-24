package com.cc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            //使用mybatis第一步，获取 SqlSessionFactory 对象
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //有了SqlSessionFactory，就可以获取 SqlSession 的实例了
    //SqlSession 包含了面向数据库执行 sql 命令所需的全部方法
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
