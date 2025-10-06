package com.sdj.bootbasic.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdj.bootbasic.dao.UserDao;
import com.sdj.bootbasic.entity.Params;
import com.sdj.bootbasic.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public PageInfo<User> getUserTest(Params params){
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        List<User> UsersList  = userDao.getUserTest();
        return PageInfo.of(UsersList);
    }
}
