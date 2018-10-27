package com.myhexin.listener;

import com.myhexin.entity.User;
import com.myhexin.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;


import static com.myhexin.Constant.RedisConst.ALL_USER;

/**
 * @program: springbootdemo
 * @description: 测试监听器
 * @author: Linweizhe
 * @create: 2018-10-25 16:16
 **/
@WebListener
public class UserListener implements ServletContextListener {
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    UserService userService;
    //注意导入的包的类型 log4j
    private Logger logger = LogManager.getLogger(this.getClass());

    public UserListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        System.out.println("ServletContext上下文初始化");
        logger.info("ServletContext上下文初始化");
        List<User> users = userService.listUsers();
        redisTemplate.delete(ALL_USER);
        redisTemplate.opsForList().leftPushAll(ALL_USER, users);
        List<User> queryUsers = redisTemplate.opsForList().range(ALL_USER, 0, -1);
//        System.out.println("缓存中的用户数量为：" + queryUsers.size());
        logger.info("缓存中的用户数量为：" + queryUsers.size());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("ServletContext上下文销毁");
    }
}
