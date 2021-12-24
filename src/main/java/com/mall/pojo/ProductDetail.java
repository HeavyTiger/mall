package com.mall.pojo;

/**
 * @author heavytiger
 * @version 1.0
 * @description 商品实体类，包含商品的信息，以及供应商的相关信息，禁止用户端修改
 * @date 2021/12/24 17:06
 */
public class ProductDetail {
    private Integer pid;

    private String pName;

    private Double price;

    private Integer stock;

    private Integer tid;

    private String tName;

    private String pDescription;

    private Integer pStatus;

    private Integer sid;

    private String sName;

    private String sPhone;

    private String sEmail;

    private String sDescription;

    public ProductDetail() {
    }

    public ProductDetail(Integer pid, String pName, Double price, Integer stock, Integer tid, String tName, String pDescription, Integer pStatus, Integer sid, String sName, String sPhone, String sEmail, String sDescription) {
        this.pid = pid;
        this.pName = pName;
        this.price = price;
        this.stock = stock;
        this.tid = tid;
        this.tName = tName;
        this.pDescription = pDescription;
        this.pStatus = pStatus;
        this.sid = sid;
        this.sName = sName;
        this.sPhone = sPhone;
        this.sEmail = sEmail;
        this.sDescription = sDescription;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", tid=" + tid +
                ", tName='" + tName + '\'' +
                ", pDescription='" + pDescription + '\'' +
                ", pStatus=" + pStatus +
                ", sid=" + sid +
                ", sName='" + sName + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sDescription='" + sDescription + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }
}
