package com.sdj.bootbasic.entity;
//javax 和 jakarta 区别
//javax是旧版的命名空间， 相反jakarta 是新的
// javax 在2017年被赠送给eclipse 基金会随后被修改命名空间为jakarta
import jakarta.persistence.*;


//  @Table 和 @Enity 注解区别， Table 是Entity注解的强化版本，使用table注解当类名和和数据库的表名不一致的情况，可以制定表名
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name ;
    @Column(name="password")
    private String password;
    @Column(name="sex")
    private String sex;
    @Column(name="age")
    private  Integer age ;
    @Column(name="phone")
    private  String  phone ;
    @Column(name="role")
    private  String  role ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
