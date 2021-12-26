package com.mall.service.impl;

import com.mall.pojo.OrderCart;
import com.mall.pojo.ProductDetail;
import com.mall.service.OrderCartService;
import com.mall.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 测试OrderCartService中的方法是否工作正常
 * @date 2021/12/25 17:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
public class OrderCartServiceImplTest {

    @Autowired
    private OrderCartService orderCartService;
    @Autowired
    private ProductService productService;

    @Test
    public void testAddOrderCart() {
/*        // 从浏览products页面添加购物车
        // 获取productId
        Integer productId = 1;
        ProductDetail productDetail = productService.queryProductDetailById(productId);
        // 封装数据
        OrderCart orderCart = new OrderCart();

        orderCart.setCustomerId(1);
        orderCart.setProductId(productDetail.getPid());
        orderCart.setProductAmount(1);
        orderCart.setProductPrice(productDetail.getPrice());
        orderCart.setStatus(1);
        orderCart.setOrderId(null);
        orderCartService.addOrderCart(orderCart);*/

        // OrderCart orderCart1 = new OrderCart(null, 1, 1, 1, 10000.00, 1, 1, null);
        OrderCart orderCart2 = new OrderCart(null, 1, 1, 1, 10000.00, 1, 1, null);
        //orderCartService.addOrderCart(orderCart1);
        orderCartService.addOrderCart(orderCart2);
    }

    @Test
    public void testDeleteOrderCartById() {
        System.out.println(orderCartService.deleteOrderCartById(2));
        System.out.println(orderCartService.deleteOrderCartById(20));
    }

    @Test
    public void testUpdateOrderCart() {
        OrderCart orderCart = new OrderCart();
        orderCart.setStatus(0);
        orderCart.setOrderCartId(3);
        System.out.println(orderCartService.updateOrderCart(orderCart));
    }

    @Test
    public void testQueryOrderCarts() {
        System.out.println(orderCartService.queryOrderCarts());
    }

    @Test
    public void testQueryOrderCartsByCustomerId() {
        for (OrderCart orderCart : orderCartService.queryOrderCartsByCustomerId(1)) {
            System.out.println(orderCart);
        }
    }

    @Test
    public void testQueryNewOrderCartsByCustomerId() {
        for (OrderCart orderCart : orderCartService.queryNewOrderCartsByCustomerId(1)) {
            System.out.println(orderCart);
        }
    }

    @Test
    public void testQueryOrderCartsByOrderId() {
        System.out.println(orderCartService.queryOrderCartsByOrderId(1));
    }
}
