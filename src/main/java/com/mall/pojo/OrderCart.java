package com.mall.pojo;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 购物车实体类，用于存储用户准备购买（或已购买）的商品信息
 * @date 2021/12/25 14:22
 */
public class OrderCart {

    private Integer orderCartId;    // 购物车id

    private Integer customerId;     // 顾客id

    private Integer productId;      // 商品id

    private Integer productAmount;  // 商品数量

    private Double productPrice;    // 商品价格

    private Integer status;         // 商品购买状态

    private Integer orderId;        // 订单id

    private String addTime;         // 添加购物车时间

    public OrderCart() {
    }

    public OrderCart(Integer orderCartId, Integer customerId, Integer productId, Integer productAmount, Double productPrice, Integer status, Integer orderId, String addTime) {
        this.orderCartId = orderCartId;
        this.customerId = customerId;
        this.productId = productId;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.status = status;
        this.orderId = orderId;
        this.addTime = addTime;
    }

    public Integer getOrderCartId() {
        return orderCartId;
    }

    public void setOrderCartId(Integer orderCartId) {
        this.orderCartId = orderCartId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "OrderCarts{" +
                "orderCartId=" + orderCartId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", productAmount=" + productAmount +
                ", productPrice=" + productPrice +
                ", status=" + status +
                ", orderId=" + orderId +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
