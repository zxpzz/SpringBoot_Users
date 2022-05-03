package cn.zxp.jdbc.service.impl;

import cn.zxp.jdbc.dao.UserDao;
import cn.zxp.jdbc.pojo.User;
import cn.zxp.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
//    @Transactional
    @Override
    public void exchangeAge(int from, int to, int age) {
        User user1=userDao.loadUser(from);
        User user2=userDao.loadUser(to);


        user1.setAge(user1.getAge()-age);
        user2.setAge(user2.getAge()+age);

        userDao.updateUser(user1);


//        int m=1/0;
        userDao.updateUser(user2);
    }

    @Override
    public User loadUser(int id) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
