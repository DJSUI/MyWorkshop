package com.sdj.bootbasic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sdj.bootbasic.dao")
public class BootBasicApplication {
//    使用pagehelper 进行分页查询
//    pagehelper 是一个github 项目  是专门为Mybatis设计的
//    1  在pom文件下添加pageHelper 依赖
//    2  在application yml 进行配置
//    3  创建一个接受前端任何参数的类（entity）
//    4  在controller 里 的请求方法中添加这个参数类
//    5  在service 里的使用这个参数类






    public static void main(String[] args) {
        SpringApplication.run(BootBasicApplication.class, args);
    }

}
