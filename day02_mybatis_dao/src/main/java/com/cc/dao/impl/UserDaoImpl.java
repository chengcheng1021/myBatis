package com.cc.dao.impl;

import com.cc.dao.IUserDao;
import com.cc.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> findAll() {
        //1、根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        //2、调用 SqlSession 中的方法，实现查询列表
        List<User> users = session.selectList("com.cc.dao.IUserDao.findAll");
        //3、释放资源
        session.close();

        return users;
    }

    /**
     * 保存用户
     *
     * @param user
     */
    public void saveUser(User user) {
        //1、根据 factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        //2、调用方法实现保存
        session.insert("com.cc.dao.IUserDao.saveUser", user);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();
    }

    /**
     * 更新用户
     *
     * @param user
     */
    public void updateUser(User user) {

    }

    /**
     * 根据 userId 删除用户
     *
     * @param userId
     */
    public void deleteUser(Integer userId) {

    }

    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    public User findById(Integer userId) {
        return null;
    }

    /**
     * 根据名称模糊查询用户
     *
     * @param userName
     * @return
     */
    public List<User> findByName(String userName) {
        return null;
    }

    /**
     * 查询总记录数
     *
     * @return
     */
    public int findTotal() {
        return 0;
    }
}
