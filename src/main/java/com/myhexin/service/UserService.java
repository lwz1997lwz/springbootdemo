package com.myhexin.service;

import com.myhexin.entity.User;

import java.util.List;

/**
 * @program: springbootdemo
 * @description: 用户接口类
 * @author: Linweizhe
 * @create: 2018-10-24 10:02
 **/
public interface UserService {
    User getUserById(int id);

    void save(User user);

    List<User> listUsers();

}
