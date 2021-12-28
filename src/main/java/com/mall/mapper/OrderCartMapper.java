package com.mall.mapper;

import com.mall.pojo.OrderCart;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description OrderCart购物车的mapper接口，处理购物车相关的查询、添加、修改需求
 * @date 2021/12/25 15:31
 */
public interface OrderCartMapper {

    /**
     * 添加购物车
     * @param orderCart 封装添加购物车
     * @return 返回影响的行数
     */
    public Integer addOrderCart(OrderCart orderCart);

    /**
     * 根据购物车表id删除记录
     * @param orderCartId 需要删除的购物车id
     * @return 返回影响的行数
     */
    public Integer deleteOrderCartById(Integer orderCartId);

    /**
     * 更新购物车的相关信息
     * @param orderCart 数据变更后的OrderCart对象，必须提供orderCartId
     * @return 返回影响的行数
     */
    public Integer updateOrderCart(OrderCart orderCart);

    /**
     * 查询所有购物车信息，使用pageHelper可实现分页查询
     * @return 返回查询到的供应商的所有信息列表
     */
    public List<OrderCart> queryOrderCarts();

    /**
     * 查询购物车中是否已存在该数据
     * @param orderCart 封装查询的条件
     * @return 查询到的
     */
    public List<Integer> queryOrderCartId(OrderCart orderCart);

    /**
     * 根据用户id查询购物车status为1或0的记录（所有记录）
     * @param orderCartId 要查询的购物车id
     * @return 对应的购物车数据
     */
    public OrderCart queryOrderCartByOrderCartId(Integer orderCartId);

    /**
     * 根据用户id查询购物车status为1或0的记录（所有记录）
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
     * 根据订单id查询购物车记录（订单界面查看订单详情）
     * @param orderId 订单id
     * @return 该订单的购物车列表
     */
    public List<OrderCart> queryOrderCartsByOrderId(Integer orderId);
}
