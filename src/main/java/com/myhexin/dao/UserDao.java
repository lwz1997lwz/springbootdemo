package com.myhexin.dao;

import com.myhexin.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
    public User getUserById(int id);
}
