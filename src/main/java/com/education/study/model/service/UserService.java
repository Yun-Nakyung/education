package com.education.study.model.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.education.study.config.AesConfig;
import com.education.study.model.mapper.UserMapper;
import com.education.study.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper uMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AesConfig aesConfig;

    public int signUpUser(User user) {
        String encodePwd = passwordEncoder.encode(user.getUserPwd());
        user.setUserPwd(encodePwd);

        String cipherEmail = null;
        String cipherPhone = null;
        try {
            cipherEmail = aesConfig.encrypt(user.getUserEmail());
            cipherPhone = aesConfig.encrypt(user.getUserPhone());
            user.setUserEmail(cipherEmail);
            user.setUserPhone(cipherPhone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return uMapper.createUser(user);
    }


    public List<User> allUsers() {

        List<User> userList = uMapper.allUsers();
        for(User u : userList){
            try {
                u.setUserEmail(aesConfig.decrypt(u.getUserEmail()));
                u.setUserPhone(aesConfig.decrypt(u.getUserPhone()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        return userList;
    }

    public User userByNo(int userNo){
        User user = uMapper.userByNo(userNo);

        try {
            user.setUserEmail(aesConfig.decrypt(user.getUserEmail()));
            user.setUserPhone(aesConfig.decrypt(user.getUserPhone()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}