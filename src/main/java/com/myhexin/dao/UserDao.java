package com.myhexin.dao;

import com.myhexin.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: springbootdemo
 * @description:
 * @author: Linweizhe
 * @create: 2018-10-24 10:08
 **/


public interface UserDao {
    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(int id);

    void save(User user);

    List<User> listUsers();
}
