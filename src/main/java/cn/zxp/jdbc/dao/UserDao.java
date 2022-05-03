package cn.zxp.jdbc.dao;

import cn.zxp.jdbc.pojo.User;

import java.util.List;

public interface UserDao {
    User loadUser(int id);
    List<User> findAllUsers();
    User addUser(User user);
    User updateUser(User user);
    int deleteUser(int id);
}
