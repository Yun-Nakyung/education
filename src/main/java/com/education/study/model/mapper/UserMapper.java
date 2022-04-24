package com.education.study.model.mapper;


import com.education.study.model.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int createUser(User user);

    List<User> allUsers();

    User userByNo(int UserNo);
}