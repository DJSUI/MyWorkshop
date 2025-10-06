package com.sdj.bootbasic.service;

import com.sdj.bootbasic.dao.ProductDao;
import com.sdj.bootbasic.entity.Product;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Resource
    ProductDao productDao;

    public Product testDataBase(){
        Product product  = productDao.testDataBase();
        return product;

    }

}
