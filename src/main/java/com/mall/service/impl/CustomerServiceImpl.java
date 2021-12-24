package com.mall.service.impl;

import com.mall.mapper.CustomerMapper;
import com.mall.pojo.Customer;
import com.mall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heavytiger
 * @version 1.0
 * @description 实现CustomerService接口
 * @date 2021/12/23 17:37
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * 添加用户
     *
     * @param customer 需要添加的用户
     * @return 返回影响行数
     */
    @Override
    public Integer addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    /**
     * 根据用户的id删除用户
     *
     * @param userId 需要删除的用户的编号
     * @return 影响的行数
     */
    @Override
    public Integer deleteCustomer(Integer userId) {
        return customerMapper.deleteCustomer(userId);
    }

    /**
     * 更新用户信息
     *
     * @param customer 更新后的结果
     * @return 影响的行数
     */
    @Override
    public Integer updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 根据用户的id查询全部信息
     *
     * @param userId 需要查询的用户的编号
     * @return 返回查询到的用户的实体
     */
    @Override
    public Customer queryCustomerById(Integer userId) {
        return customerMapper.queryCustomerById(userId);
    }

    /**
     * 查询所有的用户
     *
     * @return 返回查询到的用户列表
     */
    @Override
    public List<Customer> queryCustomers() {
        return customerMapper.queryCustomers();
    }

    /**
     * 查询用户名是否存在
     *
     * @param username 需要查找的用户名
     * @return 查询到的结果
     */
    @Override
    public Customer queryCustomerByName(String username) {
        return customerMapper.queryCustomerByName(username);
    }

    /**
     * 登录账户
     *
     * @param username 登录的账户名
     * @param password 登录的密码
     * @return 是否登录成功
     */
    @Override
    public Customer customerLogin(String username, String password) {
        Customer customer = customerMapper.queryCustomerByName(username);
        if(customer != null && password != null && !"".equals(password)) {
            if(password.equals(customer.getPassword())){
                return customer;
            } else {
                return null;
            }
        }
        return null;
    }
}
