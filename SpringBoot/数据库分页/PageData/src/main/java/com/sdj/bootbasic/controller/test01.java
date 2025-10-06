package com.sdj.bootbasic.controller;


import com.github.pagehelper.PageInfo;
import com.sdj.bootbasic.entity.Params;
import com.sdj.bootbasic.entity.User;
import com.sdj.bootbasic.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class test01 {
//    http://localhost:8080/hello    用于测试是否正常
    @Resource
    UserService userService;

    @RequestMapping("/hello")
    public String hello1(){
        return  "hllow sdj";
    }

    @GetMapping("/user")
    public PageInfo<User> getUserTest (Params params){

        PageInfo<User> res  = userService.getUserTest(params);
        return res ;
    }

}
