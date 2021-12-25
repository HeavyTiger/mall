package com.mall.service.impl;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.pojo.ProductDetail;
import com.mall.pojo.ProductSearch;
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
        ProductDetail productDetail = new ProductDetail(null, "Huawei p70", 9999.00, 0, 1, "未发布的产品",1, 15);
        System.out.println(productService.addProduct(productDetail));
    }

    @Test
    public void deleteProduct() {
        System.out.println(productService.deleteProduct(17));
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

    @Test
    public void queryProductDetailsBySearch() {
        // 第一次查询
        ProductSearch ps1 = new ProductSearch("ip", "苹果", "手", 1000.0, 10000.0);
        System.out.println("第一次查询：" + ps1);
        System.out.println(JsonUtil.objToJson(productService.queryProductDetailsBySearch(ps1, 1, 10)));
        // 第二次查询
        ProductSearch ps2 = new ProductSearch("ipad", "苹", null, 1000.00, null);
        System.out.println("第二次查询：" + ps2);
        System.out.println(JsonUtil.objToJson(productService.queryProductDetailsBySearch(ps2, 1, 10)));
        // 第三次查询
        ProductSearch ps3 = new ProductSearch(null, "苹", null, null, null);
        System.out.println("第三次查询：" + ps3);
        System.out.println(JsonUtil.objToJson(productService.queryProductDetailsBySearch(ps3, 1, 10)));
        // 第四次查询
        ProductSearch ps4 = new ProductSearch(null, null, null, null, null);
        System.out.println("第四次查询：" + ps4);
        System.out.println(JsonUtil.objToJson(productService.queryProductDetailsBySearch(ps4, -1, -10)));
    }
}