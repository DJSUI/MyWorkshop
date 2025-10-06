package com.sdj.bootbasic.controller;


import com.sdj.bootbasic.entity.Product;
import com.sdj.bootbasic.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test01 {
//    http://localhost:8080/hello    用于测试是否正常

    @Resource
    ProductService productService;

    @RequestMapping("/hello")
    public String hello1(){
        return  "hllow sdj";
    }

    @GetMapping("/test1")
    public Product testDatabase(){
        Product product1  =  productService.testDataBase();
        return product1;
    }

}
