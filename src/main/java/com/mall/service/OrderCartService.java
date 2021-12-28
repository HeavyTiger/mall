package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.OrderCart;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description OrderCartService业务层接口，提供添加购物车、更新购物车、查询购物车等服务
 * @date 2021/12/25 17:05
 */
public interface OrderCartService {

    /**
     * 添加购物车
     * @param orderCart 封装添加购物车
     * @return 返回影响的行数
     */
    public Integer addOrderCart(OrderCart orderCart);

    /**
     * 商品界面一键添加购物车服务接口
     * @param productId 商品id
     * @param customerId 客户id
     * @return 返回影响的行数
     */
    public Integer addOrderCart(Integer productId, Integer customerId);

    /**
     * 根据购物车表id删除记录
     * @param orderCartId 需要删除的购物车id
     * @return 返回影响的行数
     */
    public Integer deleteOrderCartById(Integer orderCartId);

    /**
     * 更新购物车的相关信息
     * @param orderCartId 购物车id
     * @param productAmount 更改的商品数量
     * @return 影响的行数
     */
    public Integer updateOrderCart(int orderCartId, int productAmount);

    /**
     * 查询所有购物车信息，使用pageHelper可实现分页查询
     * @return 返回查询到的供应商的所有信息列表
     */
    public List<OrderCart> queryOrderCarts();

    /**
     * 根据用户id查询购物车记录
     * @param customerId 要查询的用户id
     * @return 该用户的购物车列表
     */
    public List<OrderCart> queryOrderCartsByCustomerId(Integer customerId);

    /**
     * 根据用户id查询status为1的购物车记录（未下单记录）
     * @param customerId 要查询的用户id
     * @return 该用户的购物车列表
     */
    public List<OrderCart> queryNewOrderCartsByCustomerId(Integer customerId);

    /**
     * 根据用户id查询status为1的购物车记录（未下单记录）
     * @param customerId 要查询的用户id
     * @return 该用户的购物车列表
     */
    public PageInfo<OrderCart> queryNewOrderCartsByCustomerIdByPage(Integer customerId, Integer pageNum, Integer pageSize);


    /**
     * 根据订单id查询购物车记录（订单界面查看订单详情）
     * @param orderId 订单id
     * @return 该订单的购物车列表
     */
    public List<OrderCart> queryOrderCartsByOrderId(Integer orderId);
}
