package com.sdj.backdivide.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class Hello {

    @GetMapping("/hello")
    public  String hello(){
        return "HELLO";
    }

}
