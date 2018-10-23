package com.myhexin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootdemo
 * @description: 用于测试springBoot启动
 * @author: Linweizhe
 * @create: 2018-10-23 16:16
 **/

@Controller
public class HelloController {
    @Value("${name}")
    private String name;
    @Value("${old}")
    private int old;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloSpringBoot() {
        return "Hello SpringBoot!";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/showinfo", method = RequestMethod.GET)
    public String showInfo() {
        return name + old;
    }
}
