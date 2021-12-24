package com.mall.service;

import com.mall.pojo.Customer;

import java.util.List;

/**
 * @author heavytiger
 * @version 1.0
 * @description 封装与Customer相关的service类接口
 * @date 2021/12/23 17:30
 */

public interface CustomerService {
    /**
     * 添加用户
     * @param customer 需要添加的用户
     * @return 返回影响行数
     */
    public Integer addCustomer(Customer customer);

    /**
     * 根据用户的id删除用户
     * @param userId 需要删除的用户的编号
     * @return 影响的行数
     */
    public Integer deleteCustomer(Integer userId);

    /**
     * 更新用户信息
     * @param customer 更新后的结果
     * @return 影响的行数
     */
    public Integer updateCustomer(Customer customer);

    /**
     * 根据用户的id查询全部信息
     * @param userId 需要查询的用户的编号
     * @return 返回查询到的用户的实体
     */
    public Customer queryCustomerById(Integer userId);

    /**
     * 查询所有的用户
     * @return 返回查询到的用户列表
     */
    public List<Customer> queryCustomers();

    /**
     * 查询用户名是否存在
     * @param username 需要查找的用户名
     * @return 查询到的结果
     */
    public Customer queryCustomerByName(String username);

    /**
     * 登录账户
     * @param username 登录的账户名
     * @param password 登录的密码
     * @return 是否登录成功
     */
    public Customer customerLogin(String username, String password);
}
