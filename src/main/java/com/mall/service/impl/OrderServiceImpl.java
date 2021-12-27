package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.mapper.OrderCartMapper;
import com.mall.mapper.OrderMapper;
import com.mall.mapper.ProductMapper;
import com.mall.pojo.Order;
import com.mall.pojo.OrderCart;
import com.mall.pojo.ProductDetail;
import com.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author heavytiger
 * @version 1.0
 * @description OrderService接口实现类，实现相关的支付接口
 * @date 2021/12/26 16:38
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderCartMapper orderCartMapper;

    private final ProductMapper productMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, OrderCartMapper orderCartMapper, ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.orderCartMapper = orderCartMapper;
        this.productMapper = productMapper;
    }

    /**
     * 添加订单，若需要回滚会抛出运行时异常，需要在Controller层捕获运行时异常
     *
     * @param order 需要增加的订单
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Override
    public void addOrder(Order order) {
        // 开启事务支持，隔离级别可重复读，若被调用方法中存在事务则加入事务，否则创建新事务
        // 生成订单SN码
        order.setOrderSn(UUID.randomUUID().toString().replace("-", ""));
        // 查询当前用户购物车内的所有未购买商品
        List<OrderCart> orderCartList = orderCartMapper.queryNewOrderCartsByCustomerId(order.getCustomerId());
        // 计算总金额
        double orderTotalMoney = 0;
        for(OrderCart item : orderCartList){
            Double curPrice = item.getProductPrice();
            Integer curAmount = item.getProductAmount();
            orderTotalMoney += (curPrice == null || curAmount == null) ? 0 : curPrice * curAmount;
        }
        order.setOrderMoney(orderTotalMoney);
        // 新建一条订单，该方法将回填主键(即orderId)
        orderMapper.addOrder(order);
        Integer curOrderId = order.getOrderId();
        // 更新order_carts购物车表
        for(OrderCart item : orderCartList){
            // 将购物车表中的status状态标记为0，即已经生成订单，状态为删除
            item.setStatus(0);
            // 将库存中的数量进行更改，若数量过多，则直接抛出运行时异常
            ProductDetail curProduct = productMapper.queryProductDetailById(item.getProductId());
            Integer curStock = curProduct.getStock();
            Integer curAmount = item.getProductAmount() == null ? 0 : item.getProductAmount();
            if(curStock < curAmount){
                // 抛出异常，@Transactional捕获异常后自动回滚，Controller层需要捕获异常
                throw new RuntimeException("库存数量不够，请检查购物车中添加的商品数量！");
            } else {
                item.setOrderId(curOrderId);
                // 回写购物车内的OrderId数据
                orderCartMapper.updateOrderCart(item);
                // 更新产品中的库存stock
                curProduct.setStock(curStock - curAmount);
                productMapper.updateProduct(curProduct);
            }
        }
    }

    /**
     * 查询全部订单
     *
     * @return 返回查询到的所有订单
     */
    @Override
    public List<Order> queryOrders() {
        return orderMapper.queryOrders();
    }

    /**
     * 根据订单号查询Order
     *
     * @param orderId 需要查询的订单号
     * @return 返回查询到的订单
     */
    @Override
    public Order queryOrderByOrderId(Integer orderId) {
        return orderMapper.queryOrderByOrderId(orderId);
    }

    /**
     * 根据用户的id获取其所有订单
     *
     * @param customerId 需要查询的用户的id
     * @param pageNum 查询页码
     * @param pageSize 每页数量
     * @return 当前用户的所有订单记录
     */
    @Override
    public PageInfo<Order> queryOrdersByCustomerId(Integer customerId, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) return null;
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.queryOrdersByCustomerId(customerId);
        return new PageInfo<>(orders);
    }
}
