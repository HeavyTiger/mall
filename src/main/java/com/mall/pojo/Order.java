package com.mall.pojo;

/**
 * @author heavytiger
 * @version 1.0
 * @description Order类，订单类，用于生成订单的各种相关操作
 * @date 2021/12/26 15:05
 */
public class Order {
    private Integer orderId;

    private String orderSn;

    private Integer customerId;

    private String shippingUser;

    private String shippingAddress;

    private String shippingPhone;

    private Double orderMoney;

    private String createTime;

    public Order() {
    }

    public Order(Integer orderId, String orderSn, Integer customerId, String shippingUser, String shippingAddress, String shippingPhone, Double orderMoney, String createTime) {
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.customerId = customerId;
        this.shippingUser = shippingUser;
        this.shippingAddress = shippingAddress;
        this.shippingPhone = shippingPhone;
        this.orderMoney = orderMoney;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderSn='" + orderSn + '\'' +
                ", customerId=" + customerId +
                ", shippingUser='" + shippingUser + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingPhone='" + shippingPhone + '\'' +
                ", orderMoney=" + orderMoney +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getShippingUser() {
        return shippingUser;
    }

    public void setShippingUser(String shippingUser) {
        this.shippingUser = shippingUser;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
