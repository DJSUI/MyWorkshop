package com.sdj.bootbasic.controller;


import com.sdj.bootbasic.common.LeaveStatus;
import com.sdj.bootbasic.entity.LeaveApplication;
import com.sdj.bootbasic.service.LeaveService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test01 {
//    http://localhost:8080/hello    用于测试是否正常
    @Resource
    LeaveService leaveService ;
    @Resource
    LeaveApplication leaveApplication ;

    @RequestMapping("/hello")
    public String hello1(){
        return  "hllow sdj";
    }

    @RequestMapping("/enum")
    public String enum1(){
        leaveApplication = new LeaveApplication("张三", LeaveStatus.APPROVED);
        leaveService.processLeaveApplication(leaveApplication);
        return  "hllow sdj";
    }

}

