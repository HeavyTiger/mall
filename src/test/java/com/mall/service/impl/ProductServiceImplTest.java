package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.pojo.ProductDetail;
import com.mall.service.ProductService;
import com.mall.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author heavytiger
 * @version 1.0
 * @description 测试ProductService层
 * @date 2021/12/25 0:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
public class ProductServiceImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void addProduct() {
        ProductDetail productDetail = new ProductDetail(null, "Huawei p70", 9999.00, 0, 1, "未发布的产品",1, 5);
        System.out.println(productService.addProduct(productDetail));
    }

    @Test
    public void deleteProduct() {
        System.out.println(productService.deleteProduct(16));
        System.out.println(productService.deleteProduct(null));
    }

    @Test
    public void updateProduct() {
        ProductDetail temp = productService.queryProductDetailById(15);
        temp.setpDescription("即将上市的新品，华为p60！");
        System.out.println(productService.updateProduct(temp));
        System.out.println(productService.queryProductDetailById(15));
    }

    @Test
    public void queryProductDetails() {
        for (ProductDetail pd : productService.queryProductDetails()) {
            System.out.println(pd);
        }
    }

    @Test
    public void queryProductDetailById() {
        System.out.println(productService.queryProductDetailById(15));
        System.out.println(productService.queryProductDetailById(150));
        System.out.println(productService.queryProductDetailById(null));
    }

    @Test
    public void queryProductDetailsByPage() {
        PageInfo<ProductDetail> pageInfo = productService.queryProductDetailsByPage(2, 4);
        System.out.println(JsonUtil.objToJson(pageInfo));
    }
}