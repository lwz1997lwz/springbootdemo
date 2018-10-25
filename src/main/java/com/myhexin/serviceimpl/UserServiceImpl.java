package com.myhexin.serviceimpl;

import com.myhexin.dao.UserDao;
import com.myhexin.entity.User;
import com.myhexin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.myhexin.Constant.RedisConst.ALL_USER;

/**
 * @program: springbootdemo
 * @description:
 * @author: Linweizhe
 * @create: 2018-10-24 10:04
 **/


@Service
public class UserServiceImpl implements UserService {
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    UserDao userDao;

    @Override
    public User getUserById(int id) {
        List<User> queryUsers = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        for (User user : queryUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        User user = userDao.getUserById(id);
        if (user != null) {
            redisTemplate.opsForList().leftPush(ALL_USER, user);
        }
        return user;
    }

    @Transactional(rollbackFor =Exception.class)
    @Override
    public void save(User user) {
        userDao.save(user);
       // 空指针异常 用于模拟 事务的回滚
        String error = null;
        error.split("/");
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
