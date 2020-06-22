<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.cc.dao.IUserDao" %>
<%@ page import="com.cc.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1、读取配置文件
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

    //2、创建 SqlSessionFactory 工厂
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(in);

    //3、使用工厂生产 SqlSession 对象
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //4、使用 SqlSession 创建 Dao 接口的代理对象
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);

    //5、使用代理对象执行方法
    List<User> users = userDao.findAll();
    for (User user : users) {
        System.out.println(user);
    }

    //6、释放资源
    sqlSession.close();
    in.close();
%>
</body>
</html>
