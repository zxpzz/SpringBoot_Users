package cn.zxp.jdbc.dao.impl;

import cn.zxp.jdbc.dao.UserDao;
import cn.zxp.jdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public User loadUser(int id) {
        String sql="select*from users where id=?";
        List<User> users= template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setPassword(rs.getString("password"));
                user.setUname(rs.getString("uname"));
                return user;
            }
        },id);
        return users.get(0);
    }

    @Override
    public List<User> findAllUsers() {
        String sql="select*from users";
        List<User> users= template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setAge(rs.getInt("age"));
                user.setPassword(rs.getString("password"));
                user.setUname(rs.getString("uname"));
                return user;
            }
        });
        return users;
    }

    @Override
    public User addUser(User user) {
       String sql="insert into users(uname,password,age) values(?,?,?)";


       int rs=template.update(sql,user.getUname(),user.getPassword(),user.getAge());
        if (rs>0){
            int id=template.queryForObject("select last_insert_id() from dual",Integer.class);
            user.setId(id);
            return user;

        }
        else {
            return null;
        }






    }

    @Override
    public User updateUser(User user) {
        String sql="update users set uname=?,password=?,age=? where id=?";
        int rs=template.update(sql,user.getUname(),user.getPassword(),user.getAge(),user.getId());
        if (rs>0){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public int deleteUser(int id) {
        String sql="delete from users where id=?";
        int rs= template.update(sql,id);
        return rs;
    }
}
