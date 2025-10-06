package com.sdj.bootbasic.entity;

import jakarta.persistence.*;

@Table(name= "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private String price;
    @Column(name="manufacturer")
    private Integer manufacturer;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Integer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
