package com.mall.controller;

import com.mall.pojo.Customer;
import com.mall.pojo.EnumResult;
import com.mall.pojo.ResultBean;
import com.mall.service.CustomerService;
import com.mall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author heavytiger
 * @version 1.0
 * @description CustomerController, 实现用户修改，登录，注册等相关功能
 * @date 2021/12/23 20:18
 */
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 顾客登录，获取token值，除注册和登录外的所有操作都需要在headers中的Authorization键附上token值鉴权
     *
     * @param tmpCustomer 通过body体获取前端的json数据
     * @return 若登录成功，返回success以及token，否则返回wrong_up提示帐号或密码错误
     */
    @PostMapping("/login")
    public ResultBean<Object> tryLogin(@RequestBody Customer tmpCustomer) {

        Customer customer = customerService.customerLogin(tmpCustomer.getUsername(), tmpCustomer.getPassword());
        if (customer != null) {
            // 说明登陆成功
            String token = JwtUtil.sign(customer.getUserId(), customer.getUsername());
            return new ResultBean<>(EnumResult.SUCCESS, token);
        } else {
            // 说明登录失败
            return new ResultBean<>(EnumResult.WRONG_UP);
        }
    }

    /**
     * 判断用户名是否存在
     *
     * @param username 需要判断是否存在的用户名，通过param传输
     * @return 若存在返回success 200，不存在返回fail 400
     */
    @GetMapping("/userExist")
    public ResultBean<Object> ifExistUsername(String username) {
        Customer customer = customerService.queryCustomerByName(username);
        if (customer != null) {
            // 说明存在该用户，返回请求失败
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            // 说明不存在，可以注册
            return new ResultBean<>(EnumResult.SUCCESS);
        }
    }

    /**
     * 更新customer的对象信息
     *
     * @param customer 需要修改的customer信息，使用body中的json数据
     * @param request  获取请求头中的token，得到uid进行校验
     * @return 返回是否成功
     */
    @PutMapping("/customer")
    public ResultBean<Object> updateCustomer(@RequestBody Customer customer, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Integer userId = JwtUtil.getUserId(token);
        String oldUsername = JwtUtil.getUsername(token);
        if (customer == null || !Objects.equals(userId, customer.getUserId())) {
            // 若customer为空，或着两者的uid不相等
            // 说明此时用户上传的body中uid被修改，报错401,签名错误
            return new ResultBean<>(EnumResult.UNAUTHORIZED);
        } else {
            // 1. 首先判断用户是否未改动帐号，若未改动，允许修改。2. 若已改动帐号，需要判断用户修改的帐号是否冲突
            assert oldUsername != null;     // 断言不可能为空，因为进入到该步骤的一定通过了登录并且获取到了token，username必不为空
            if (!oldUsername.equals(customer.getUsername()) && customerService.queryCustomerByName(customer.getUsername()) != null) {
                // 若用户此时修改了用户名，并且数据库中存在同名用户，则禁止修改，否则会报错duplicate entry for key
                return new ResultBean<>(EnumResult.FAIL);
            } else {
                // 不需要判断是否存在，允许直接修改
                customerService.updateCustomer(customer);
                return new ResultBean<>(EnumResult.SUCCESS);
            }
        }
    }

    /**
     * 注册customer
     *
     * @param customer 需要插入的customer信息，使用body中的json数据
     * @return 返回是否成功
     */
    @PostMapping("/register")
    public ResultBean<Object> registerCustomer(@RequestBody Customer customer) {
        if (customer == null || customerService.queryCustomerByName(customer.getUsername()) != null) {
            // 说明前端没有提供customer, 或者查到的用户名结果不为空，报错
            return new ResultBean<>(EnumResult.FAIL);       // 报请求失败
        } else {
            // 说明成功
            if (customerService.addCustomer(customer) != 0) {
                // 说明影响了至少一条记录，正常
                return new ResultBean<>(EnumResult.SUCCESS);
            } else {
                return new ResultBean<>(EnumResult.FAIL);       // 报请求失败
            }
        }
    }

    /**
     * 获取用户的相关数据
     *
     * @param request 获取请求头中的token，得到uid进行校验
     * @return 返回得到的customer数据，将密码设为null，存在token时uid无法被修改，前端可不用复杂校验
     */
    @GetMapping("/customer")
    public ResultBean<Object> getCustomer(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Integer userId = JwtUtil.getUserId(token);
        Customer customer = customerService.queryCustomerById(userId);
        customer.setPassword(null);
        return new ResultBean<>(EnumResult.SUCCESS, customer);
    }
}
