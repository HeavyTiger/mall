package com.mall.mapper;

import com.mall.pojo.Order;

import java.util.List;

/**
 * @author heavytiger
 * @version 1.0
 * @description OrderMapper订单的mapper层，处理和订单相关的增删改查数据库需求
 * @date 2021/12/26 15:33
 */
public interface OrderMapper {

    /**
     * 添加订单
     * @param order 需要增加的订单
     * @return 返回影响的行数
     */
    public Integer addOrder(Order order);

    /**
     * 删除订单
     * @param orderId 需要删除的订单号
     * @return 返回影响的行数
     */
    public Integer deleteOrder(Integer orderId);

    /**
     * 修改订单
     * @param order 需要修改的订单
     * @return 返回影响的行数
     */
    public Integer updateOrder(Order order);

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
     * @return 当前用户的所有订单记录
     */
    public List<Order> queryOrdersByCustomerId(Integer customerId);
}
