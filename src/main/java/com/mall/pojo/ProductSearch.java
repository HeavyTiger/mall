package com.mall.pojo;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author heavytiger
 * @version 1.0
 * @description ProductSearch类，辅助封装查询数据，允许对产品进行模糊查询
 * @date 2021/12/25 16:31
 */
public class ProductSearch {
    @JsonAlias(value = {"pDescription", "pDesc", "productDesc"})
    private String productDescription;      // 产品信息描述

    @JsonAlias(value = {"sDescription", "sDesc", "supplierDesc"})
    private String supplierDescription;     // 供应商描述

    @JsonAlias(value = {"tDescription", "tDesc", "tagDesc"})
    private String tagDescription;          // 产品分类标签描述

    @JsonAlias(value = {"min", "minValue"})
    private Double minPrice;                // 最低价格

    @JsonAlias(value = {"max", "maxValue"})
    private Double maxPrice;                // 最高价格

    public ProductSearch() {
    }

    public ProductSearch(String productDescription, String supplierDescription, String tagDescription, Double minPrice, Double maxPrice) {
        this.productDescription = productDescription;
        this.supplierDescription = supplierDescription;
        this.tagDescription = tagDescription;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "ProductSearch{" +
                "productDescription='" + productDescription + '\'' +
                ", supplierDescription='" + supplierDescription + '\'' +
                ", tagDescription='" + tagDescription + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSupplierDescription() {
        return supplierDescription;
    }

    public void setSupplierDescription(String supplierDescription) {
        this.supplierDescription = supplierDescription;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
