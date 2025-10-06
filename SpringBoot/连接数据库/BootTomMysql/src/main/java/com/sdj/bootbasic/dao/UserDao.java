package com.sdj.bootbasic.dao;

import com.sdj.bootbasic.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserTest();
}
