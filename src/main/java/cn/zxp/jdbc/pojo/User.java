package cn.zxp.jdbc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
    private Integer id;
    public  String uname;
    private String password;
    private  int age;
}
