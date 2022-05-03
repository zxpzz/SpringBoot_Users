package cn.zxp.jdbc.service;

import cn.zxp.jdbc.pojo.User;

import java.util.List;

public interface UserService {
    void exchangeAge(int from,int to,int age);

    User loadUser(int id);
    List<User> findAllUser();
    User addUser(User user);
    User updateUser(User user);
    int deleteUser(int id);



}
