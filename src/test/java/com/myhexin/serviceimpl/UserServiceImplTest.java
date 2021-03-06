package com.myhexin.serviceimpl;

import com.myhexin.SpringbootdemoApplication;
import com.myhexin.entity.User;
import com.myhexin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
;

@SpringBootTest(classes = SpringbootdemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}