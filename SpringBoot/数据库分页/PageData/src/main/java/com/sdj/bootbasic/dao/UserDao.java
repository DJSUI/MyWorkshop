package com.sdj.bootbasic.dao;

import com.sdj.bootbasic.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserTest();
}
