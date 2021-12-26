package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Order;

import java.util.List;

/**
 * @author heavytiger
 * @version 1.0
 * @description OrderService业务层接口，关于订单的相关接口，如生成订单，查询订单等
 * @date 2021/12/26 16:15
 */
public interface OrderService {
    /**
     * 添加订单
     * @param order 需要增加的订单
     */
    public void addOrder(Order order);


    /**
     * 查询全部订单
     * @return 返回查询到的所有订单
     */
    public List<Order> queryOrders();

    /**
     * 根据订单号查询Order
     * @param orderId 需要查询的订单号
     * @return 返回查询到的订单
     */
    public Order queryOrderByOrderId(Integer orderId);

    /**
     * 根据用户的id获取其所有订单
     * @param customerId 需要查询的用户的id
     * @param pageNum 查询页码
     * @param pageSize 每页数量
     * @return 当前用户的所有订单记录
     */
    public PageInfo<Order> queryOrdersByCustomerId(Integer customerId, Integer pageNum, Integer pageSize);
}
