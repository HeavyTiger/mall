package com.mall.service.impl;

import com.mall.pojo.Order;
import com.mall.pojo.OrderCart;
import com.mall.service.OrderCartService;
import com.mall.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @author heavytiger
 * @version 1.0
 * @description 测试订单业务是否正常
 * @date 2021/12/26 18:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderCartService orderCartService;

    @Test
    public void addOrder() {
        Order order1 = new Order(null, null, 3, "邓晟淼", "武汉理工",
                "15327618268", null, null);
        Order order2 = new Order(null, null, 2, "邢淳杰", "武汉理工",
                "11234567890", null, null);
        try {
            orderService.addOrder(order1);
        } catch (RuntimeException r){
            r.printStackTrace();
        }
    }

    @Test
    public void queryOrders() {
        for (Order order : orderService.queryOrders()) {
            System.out.println(order);
            for (OrderCart orderCart : orderCartService.queryOrderCartsByOrderId(order.getOrderId())) {
                System.out.println(orderCart);
            }
        }
    }

    @Test
    public void queryOrderByOrderId() {
        System.out.println(orderService.queryOrderByOrderId(8));
    }

    @Test
    public void queryOrdersByCustomerId() {
        for (Order order : orderService.queryOrdersByCustomerId(3)) {
            System.out.println(order);
            for (OrderCart orderCart : orderCartService.queryOrderCartsByOrderId(order.getOrderId())) {
                System.out.println(orderCart);
            }
        }
    }
}