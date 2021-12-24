package com.mall.mapper;

import com.mall.pojo.Customer;

import java.util.List;

/**
 * @author heavytiger
 * @version 1.0
 * @description Customer实体类对应的mapper层接口
 * @date 2021/12/23 16:59
 */
public interface CustomerMapper {
    /**
     * 将客户信息添加到数据库中，即注册操作
     * @param customer 需要添加的客户
     * @return 返回影响的行数
     */
    public Integer addCustomer(Customer customer);

    /**
     * 删除客户，实际上本例不需要删除操作，未设置注销用户的功能
     * @param userId 需要删除的客户id
     * @return 返回影响的行数
     */
    public Integer deleteCustomer(Integer userId);


    /**
     * 更新客户的相关信息
     * @param customer 需要修改的改动后的customer，必须提供userId
     * @return 返回影响到的行数
     */
    public Integer updateCustomer(Customer customer);

    /**
     * 查询所有用户信息，使用pageHelper可实现分页查询
     * @return 返回查询到的用户的所有信息
     */
    public List<Customer> queryCustomers();

    /**
     * 通过userId查询相关的用户
     * @param userId 需要查询的用户id
     * @return 若存在返回客户对象，若不存在返回null
     */
    public Customer queryCustomerById(Integer userId);

    /**
     * 通过账户名检测是否存在用户，可实现前端校验用户名是否重复的功能
     * @param userName 需要检测的用户名
     * @return 若存在该名称的用户，返回用户信息，否则返回null
     */
    public Customer queryCustomerByName(String userName);
}
