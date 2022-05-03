package cn.zxp.jdbc.mapper;

import cn.zxp.jdbc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUser(int id);
    List<User> findAllUser();
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
