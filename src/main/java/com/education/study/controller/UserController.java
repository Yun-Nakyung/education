package com.education.study.controller;

import com.education.study.model.service.UserService;
import com.education.study.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService uService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        int createUser = uService.signUpUser(user);
        User insertUser = uService.userByNo(createUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(insertUser);
    }

    @GetMapping("/user")
    public List<User> allUsers(){
        return uService.allUsers();
    }
}
