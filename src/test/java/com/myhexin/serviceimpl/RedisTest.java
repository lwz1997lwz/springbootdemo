package com.myhexin.serviceimpl;
import com.myhexin.entity.User;
import com.myhexin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.myhexin.Constant.RedisConst.ALL_USER;

/**
 * @program: springbootdemo
 * @description: 用于测试连接redis
 * @author: Linweizhe
 * @create: 2018-10-25 16:27
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        //增 key：name，value：ay
        redisTemplate.opsForValue().set("name","ay");
        String name = (String)redisTemplate.opsForValue().get("name");
        System.out.println(name);
        //删除
        redisTemplate.delete("name");
        //更新
        redisTemplate.opsForValue().set("name","al");
        //查询
        name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
    @Test
    public void testRedisList(){
        List<User> users = userService.listUsers();
//        List<String> usernames = new ArrayList<>();
//        for (User user : users) {
//            usernames.add(user.getUserName());
//        }
        redisTemplate.delete(ALL_USER);
        redisTemplate.opsForList().leftPushAll(ALL_USER,users);
        List<User> queryUsers = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        System.out.println("缓存中的用户数量为：" + queryUsers.size());
    }
}
