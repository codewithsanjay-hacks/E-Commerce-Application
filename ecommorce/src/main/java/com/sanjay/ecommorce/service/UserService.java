package com.sanjay.ecommorce.service;


import com.sanjay.ecommorce.entity.User;
import com.sanjay.ecommorce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User registerUser( User user){

        try {
            User newUser= userRepository.save(user);
            System.out.println("user added succesfully"); // manually we should add
            return newUser;

        }catch (Exception e){
            e.printStackTrace();

        }
         return null;
    }


    public User loginUser(String email, String password) {

      User user= userRepository.findByEmail(email);

      if ( user!=null  && user.getPassword().equals(password) ){
          return user;
      }


          System.out.println("invalid user details");
           return null;


    }



    public List<User> getAlLUser(){

        return userRepository.findAll();

    }
}
