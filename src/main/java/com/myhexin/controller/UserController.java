package com.myhexin.controller;

import com.myhexin.entity.User;
import com.myhexin.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * @program: springbootdemo
 * @description: 用户控制器
 * @author: Linweizhe
 * @create: 2018-10-24 09:59
 **/

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(Model model) {
        User user = userService.getUserById(1);
        model.addAttribute("username", user.getUserName());
        model.addAttribute("user",user);
        return "index";
    }
}
