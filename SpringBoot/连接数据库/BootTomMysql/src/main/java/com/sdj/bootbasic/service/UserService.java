package com.sdj.bootbasic.service;


import com.sdj.bootbasic.dao.UserDao;
import com.sdj.bootbasic.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public User getUserTest(){
        User user = userDao.getUserTest();
        return  user;
    }
}
