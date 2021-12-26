package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.mapper.CustomerMapper;
import com.mall.mapper.OrderCartMapper;
import com.mall.mapper.ProductMapper;
import com.mall.pojo.OrderCart;
import com.mall.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 实现OrderCartService接口
 * @date 2021/12/25 17:31
 */
@Service("orderCartService")
public class OrderCartServiceImpl implements OrderCartService {

    private final OrderCartMapper orderCartMapper;

    private final CustomerMapper customerMapper;

    private final ProductMapper productMapper;

    @Autowired
    public OrderCartServiceImpl(OrderCartMapper orderCartMapper, CustomerMapper customerMapper, ProductMapper productMapper) {
        this.orderCartMapper = orderCartMapper;
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
    }

    /**
     * 添加购物车
     * @param orderCart 封装添加购物车
     * @return 返回影响的行数
     */
    @Override
    public Integer addOrderCart(OrderCart orderCart) {
        if (customerMapper.queryCustomerById(orderCart.getCustomerId()) != null &&
            productMapper.queryProductDetailById(orderCart.getProductId()) != null) {
            // 默认加入购物车时标识为1，即下单时购买该商品
            orderCart.setStatus(1);
            return orderCartMapper.addOrderCart(orderCart);
        }
        return null;
    }

    /**
     * 根据购物车表id删除记录
     * @param orderCartId 需要删除的购物车id
     * @return 返回影响的行数
     */
    @Override
    public Integer deleteOrderCartById(Integer orderCartId) {
        return orderCartMapper.deleteOrderCartById(orderCartId);
    }

    /**
     * 更新购物车的相关信息
     * @param orderCart 数据变更后的OrderCart对象，必须提供orderCartId
     * @return 返回影响的行数
     */
    @Override
    public Integer updateOrderCart(OrderCart orderCart) {
        if (customerMapper.queryCustomerById(orderCart.getCustomerId()) != null &&
                productMapper.queryProductDetailById(orderCart.getProductId()) != null) {
            // 默认加入购物车时标识为1，即下单时购买该商品
            orderCart.setStatus(1);
            return orderCartMapper.updateOrderCart(orderCart);
        }
        return null;
    }

    /**
     * 查询所有购物车信息，使用pageHelper可实现分页查询
     * @return 返回查询到的供应商的所有信息列表
     */
    @Override
    public List<OrderCart> queryOrderCarts() {
        return orderCartMapper.queryOrderCarts();
    }

    /**
     * 根据用户id查询购物车记录
     * @param customerId 要查询的用户id
     * @return 该用户的购物车列表
     */
    @Override
    public List<OrderCart> queryOrderCartsByCustomerId(Integer customerId) {
        return orderCartMapper.queryOrderCartsByCustomerId(customerId);
    }

    @Override
    public List<OrderCart> queryNewOrderCartsByCustomerId(Integer customerId) {
        return orderCartMapper.queryNewOrderCartsByCustomerId(customerId);
    }

    @Override
    public PageInfo<OrderCart> queryNewOrderCartsByCustomerIdByPage(Integer customerId, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) return null;
        PageHelper.startPage(pageNum, pageSize);
        List<OrderCart> orderCarts = orderCartMapper.queryNewOrderCartsByCustomerId(customerId);
        return new PageInfo<>(orderCarts);
    }

    /**
     * 根据订单id查询购物车记录（订单界面查看订单详情）
     * @param orderId 订单id
     * @return 该订单的购物车列表
     */
    @Override
    public List<OrderCart> queryOrderCartsByOrderId(Integer orderId) {
        return orderCartMapper.queryOrderCartsByOrderId(orderId);
    }
}
