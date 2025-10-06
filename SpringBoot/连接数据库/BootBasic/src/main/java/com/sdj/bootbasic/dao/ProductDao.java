package com.sdj.bootbasic.dao;

import com.sdj.bootbasic.entity.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

    Product testDataBase();
}
