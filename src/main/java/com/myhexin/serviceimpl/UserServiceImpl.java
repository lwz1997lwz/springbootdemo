package com.myhexin.serviceimpl;

import com.myhexin.dao.UserDao;
import com.myhexin.entity.User;
import com.myhexin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springbootdemo
 * @description:
 * @author: Linweizhe
 * @create: 2018-10-24 10:04
 **/

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
