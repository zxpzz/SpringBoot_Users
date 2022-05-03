package cn.zxp.jdbc.controller;

import cn.zxp.jdbc.dao.UserDao;
import cn.zxp.jdbc.pojo.User;
import cn.zxp.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    public UserService service;
    @RequestMapping(value = "/users/{id}")
    public User locdUser(@PathVariable(value = "id") int id){
        User user= service.loadUser(id);
        return user;


    }
//    @RequestMapping(value = "users")
    @GetMapping(value = "/users")
    public List<User> findAllUsers(){
        return service.findAllUser();

    }
    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user){

        return service.addUser(user);

    }
    @PutMapping(value = "/users")
    public User updateUsers(@RequestBody User user){

        return service.updateUser(user);

    }
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        int m=service.deleteUser(id);
        MultiValueMap<String,String> map=new LinkedMultiValueMap<>();
        map.set("Content-Type","application/json");
        if (m>0){

            ResponseEntity entity=new ResponseEntity("{}",map, HttpStatus.OK);

            return entity;


        }
        else {

            ResponseEntity entity=new ResponseEntity("{info:'error'}",map, HttpStatus.EXPECTATION_FAILED);
            return entity;

        }

    }



}
