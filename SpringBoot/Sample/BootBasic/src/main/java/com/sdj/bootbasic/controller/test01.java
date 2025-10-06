package com.sdj.bootbasic.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test01 {
//    http://localhost:8080/hello    用于测试是否正常
    @RequestMapping("/hello")
    public String hello1(){
        return  "hllow sdj";
    }
}
