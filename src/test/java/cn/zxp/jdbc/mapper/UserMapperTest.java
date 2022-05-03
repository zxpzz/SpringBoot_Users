package cn.zxp.jdbc.mapper;

import cn.zxp.jdbc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;
    @Test
    public void testloadUser(){
        User user=mapper.loadUser(1);
        System.out.println(user.getUname());
    }
    @Test
    public void testFindAllUser(){
        List<User> users=mapper.findAllUser();
        users.forEach(user ->{
                    System.out.println(user.getUname());
                }
                );
    }
    @Test
    public void testAddUser(){
        User user=new User();
        user.setUname("lzz");
        user.setPassword("236");
        user.setAge(20);
        mapper.addUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setId(1);
        user.setUname("zdz");
        user.setPassword("236");
        user.setAge(20);
        mapper.updateUser(user);

    }
    @Test
    public void testDeleteUser(){
        int m= mapper.deleteUser(2);
        System.out.println(m);
    }
}