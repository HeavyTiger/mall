package com.mall.controller;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.EnumResult;
import com.mall.pojo.ProductDetail;
import com.mall.pojo.ProductSearch;
import com.mall.pojo.ResultBean;
import com.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heavytiger
 * @version 1.0
 * @description ProductController, 实现产品的增删改查功能，以及商品页的详情搜索功能
 * @date 2021/12/25 13:54
 */
@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product")
    public ResultBean<Object> getProductDetails(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestBody(required = false) ProductSearch productSearch)
    {
        // 默认从第一面开始，查询10条记录
        PageInfo<ProductDetail> pageInfo = productService.queryProductDetailsBySearch(productSearch, pageNum, pageSize);
        if(pageInfo == null) {
            // 说明数据有误
            return new ResultBean<>(EnumResult.FAIL);
        } else {
            return new ResultBean<>(EnumResult.SUCCESS, pageInfo);
        }
    }
}
