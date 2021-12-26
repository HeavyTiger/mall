package com.mall.controller;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.EnumResult;
import com.mall.pojo.Order;
import com.mall.pojo.ResultBean;
import com.mall.service.OrderService;
import com.mall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author heavytiger
 * @version 1.0
 * @description Order订单相关方法的接口层，包含订单的生成，订单的查询等接口
 * @date 2021/12/26 21:10
 */
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/order")
    public ResultBean<Object> createOrder(@RequestBody Order order, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Integer userId = JwtUtil.getUserId(token);
        if(order.getShippingUser() == null) {
            // 若未传入订单的用户姓名，将使用帐号值作为shippingUser值
            order.setShippingUser(JwtUtil.getUsername(token));
        }
        order.setCustomerId(userId);
        try{
            // 若报错，说明事务回滚，即查询失败
            orderService.addOrder(order);
        } catch (RuntimeException runtimeException) {
            // 返回失败信息
            return new ResultBean<>(EnumResult.FAIL);
        }
        return new ResultBean<>(EnumResult.SUCCESS);
    }

    @GetMapping(value = "/order")
    public ResultBean<Object> getOrders(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            HttpServletRequest request)
    {
        // 获取token值，得到customerId
        String token = request.getHeader("Authorization");
        Integer userId = JwtUtil.getUserId(token);
        // 默认记录从第一面开始，查询10条订单记录
        PageInfo<Order> pageInfo = orderService.queryOrdersByCustomerId(userId, pageNum, pageSize);
        if(pageInfo == null) {
            // 说明数据有误
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            return new ResultBean<>(EnumResult.SUCCESS, pageInfo);
        }
    }
}
