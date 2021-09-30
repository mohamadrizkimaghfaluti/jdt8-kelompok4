package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.User;
import com.example.MiniProjectUniversity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    /*@PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        //User user1 = service.create(user);
        //return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }*/

}
