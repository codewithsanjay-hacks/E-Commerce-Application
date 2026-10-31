package com.sanjay.ecommorce.controller;


import com.sanjay.ecommorce.entity.User;
import com.sanjay.ecommorce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody User user){
      return   userService.loginUser(user.getEmail(),user.getPassword());
    }

    @GetMapping("/get")
    public List<User> getALL(){

        return userService.getAlLUser();
    }
}
