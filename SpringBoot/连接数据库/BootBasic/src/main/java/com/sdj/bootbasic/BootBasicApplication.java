package com.sdj.bootbasic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sdj.bootbasic.dao")
public class BootBasicApplication {
//    连接数据库步骤
//    1 在pom 里添加相关依赖
//    2 在application 文件里编写关于数据库相关的信息
//    3  创建entity 类以接受数据库传递来的数据
//    4  添加mybatis 依赖
//    5  在application 文件里配置下数据库到ennity类文件夹的映射
//    6  在入口文件添加注解
//    7  创建dao service controller 文件
//    8  在resources下添加mapper 文件夹 和mapper下的xml文件

    public static void main(String[] args) {
        SpringApplication.run(BootBasicApplication.class, args);
    }

}
