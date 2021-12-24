package com.mall.pojo;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 供应商实体类，用于关联商品、修改商品信息及数据展示
 * @date 2021/12/24 17:37
 */
public class Supplier {

    private Integer supplierId; // 供应商id

    private String username;    // 供应商用户名

    private String password;    // 供应商密码

    private String phone;       // 供应商联系方式（电话）

    private String email;       // 供应商联系方式（邮箱）

    private String description; // 供应商描述

    public Supplier() {
    }

    public Supplier(Integer supplierId, String username, String password, String phone, String email, String description) {
        this.supplierId = supplierId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
