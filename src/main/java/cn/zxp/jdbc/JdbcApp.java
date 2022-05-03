package cn.zxp.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JdbcApp {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApp.class,args);
    }
}
