package com.sdj.bootbasic.controller;


import com.sdj.bootbasic.common.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class test01 {
//    测试接口     http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello1(){
        return  "This section about  storing  data into obj ";
    }
//    测试存储发返回结果
//    返回值成功测试接口   http://localhost:8080/Success1
    @RequestMapping("/Success1")
    public ResultData Success1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return  ResultData.SuccessData(list);
    }
//    返回值失败测试接口  http://localhost:8080/fail1
    @RequestMapping("/fail1")
    public ResultData fail1(){
        return  ResultData.FailData(512,"业务不符合逻辑");
    }

}
