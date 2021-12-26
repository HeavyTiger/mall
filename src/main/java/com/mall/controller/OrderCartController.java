package com.mall.controller;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.EnumResult;
import com.mall.pojo.OrderCart;
import com.mall.pojo.ResultBean;
import com.mall.service.OrderCartService;
import com.mall.util.JwtUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description OrderCartController 实现购物车的增删改查功能
 * @date 2021/12/26 16:18
 */
@RestController
public class OrderCartController {

    private OrderCartService orderCartService;

    @Autowired
    public void setOrderCartService(OrderCartService orderCartService) {
        this.orderCartService = orderCartService;
    }

    /**
     * 添加购物车操作，自动向购物车添加数量为1的商品信息
     * @param productId 商品id
     * @param request HTTP请求对象，封装token
     * @return 返回是否成功
     */
    @PostMapping(value = "/orderCart/{productId}")
    public ResultBean<Object> addOrderCart(@PathVariable Integer productId, HttpServletRequest request) {
        // 通过token获取当前用户id
        String token = request.getHeader("Authorization");
        Integer userId = JwtUtil.getUserId(token);

        // 添加数据
        Integer addFlag = orderCartService.addOrderCart(productId, userId);

        // 返回结果
        if (addFlag == null || addFlag == 0) {
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            return new ResultBean<>(EnumResult.SUCCESS);
        }
    }

    /**
     * 根据购物车id删除购物车表的一行记录
     * @param orderCartId 购物车id
     * @return 返回是否成功
     */
    @DeleteMapping(value = "/orderCart/{orderCartId}")
    public ResultBean<Object> deleteOrderCart(@PathVariable Integer orderCartId) {
        // 删除数据
        Integer deleteFlag = orderCartService.deleteOrderCartById(orderCartId);
        // 返回结果
        if (deleteFlag == null || deleteFlag == 0) {
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            return new ResultBean<>(EnumResult.SUCCESS);
        }
    }

    /**
     * 更新购物车接口
     * @param orderCart 修改后的购物车数据
     * @return 返回是否成功
     */
    @PutMapping(value = "/orderCart")
    public ResultBean<Object> updateOrderCart(@RequestBody OrderCart orderCart) {
        // 更新数据
        orderCartService.updateOrderCart(orderCart);
        // 返回结果
        return new ResultBean<>(EnumResult.SUCCESS);
    }

    /**
     * 用户购物车数据展示，仅展示当前用户未购买（order_carts.status==1）的购物车数据
     * @param pageNum 当前页码
     * @param pageSize 单页数据行数
     * @param request HTTP请求对象，封装token
     * @return 返回是否成功
     */
    @GetMapping(value = "/orderCart")
    public ResultBean<Object> showOrderCart(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            HttpServletRequest request) {
        // 通过token获取当前用户id
        String token = request.getHeader("Authorization");
        Integer userId = JwtUtil.getUserId(token);

        // 默认显示第1页数据，查询10条记录
        PageInfo<OrderCart> pageInfo = orderCartService.queryNewOrderCartsByCustomerIdByPage(userId, pageNum, pageSize);
        if (pageInfo == null) {
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            return new ResultBean<>(EnumResult.SUCCESS, pageInfo);
        }
    }

    /**
     * 根据订单id查询该订单对应的购物车列表
     * @param orderId 订单id
     * @return 返回查询到的购物数据
     */
    @GetMapping(value = "/orderCart/{orderId}")
    public ResultBean<Object> showOrderCartByOrderId(@PathVariable Integer orderId) {

        List<OrderCart> orderCartList = orderCartService.queryOrderCartsByOrderId(orderId);
        if (orderCartList == null) {
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            return new ResultBean<>(EnumResult.SUCCESS, orderCartList);
        }
    }
}
