package com.mall.pojo;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author heavytiger
 * @version 1.0
 * @description 顾客实体类，用于登录以及信息展示
 * @date 2021/12/23 16:54
 */
public class Customer {

    @JsonAlias(value = {"id", "uid", "customerId", "cid"})
    private Integer userId;

    @JsonAlias(value = {"Username", "userName", "name", "Name"})
    private String username;

    private String password;

    private String gender;

    private String phone;

    private String email;

    private String description;

    public Customer() {
    }

    public Customer(Integer userId, String username, String password, String gender, String phone, String email, String description) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer customerId) {
        this.userId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
