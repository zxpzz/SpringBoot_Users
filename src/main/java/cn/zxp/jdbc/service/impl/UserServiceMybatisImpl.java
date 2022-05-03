package cn.zxp.jdbc.service.impl;

import cn.zxp.jdbc.mapper.UserMapper;
import cn.zxp.jdbc.pojo.User;
import cn.zxp.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceMybatisImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public void exchangeAge(int from, int to, int age) {

    }

    @Override
    public User loadUser(int id) {
        return mapper.loadUser(id);
    }

    @Override
    public List<User> findAllUser() {
        return mapper.findAllUser();
    }

    @Override
    public User addUser(User user) {
        int m=mapper.addUser(user);
        if (m>0) return user;

        else return null;
    }

    @Override
    public User updateUser(User user) {

        int m=mapper.updateUser(user);
        if (m>0) return user;

        else return null;
    }

    @Override
    public int deleteUser(int id) {
        return mapper.deleteUser(id);
    }
}
