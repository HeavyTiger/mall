package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.mapper.ProductMapper;
import com.mall.pojo.ProductDetail;
import com.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heavytiger
 * @version 1.0
 * @description ProductServiceImpl类，实现ProductService接口与产品相关的服务
 * @date 2021/12/25 0:13
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    /**
     * 增加products表中的产品，将不使用product_detail视图，不做接口，仅在Junit中测试插入功能
     *
     * @param productDetail 需要插入的产品，请注意，此处只能使用products表中的相关字段插入，其他表中字段无效
     * @return 影响的行数
     */
    @Override
    public Integer addProduct(ProductDetail productDetail) {
        return productMapper.addProduct(productDetail);
    }

    /**
     * 删除products表中的产品，将不使用product_detail视图，不做接口，仅在Junit中共测试删除功能
     *
     * @param pid 需要删除的产品的id
     * @return 影响的行数
     */
    @Override
    public Integer deleteProduct(Integer pid) {
        return productMapper.deleteProduct(pid);
    }

    /**
     * 更新Products表中的产品，将不使用product_detail视图，不做接口，仅在Junit中共测试更新功能
     *
     * @param productDetail 需要修改的产品信息
     * @return 影响的行数
     */
    @Override
    public Integer updateProduct(ProductDetail productDetail) {
        return productMapper.updateProduct(productDetail);
    }

    /**
     * 获取查询到的产品信息列表
     *
     * @return 返回查询到的产品信息列表
     */
    @Override
    public List<ProductDetail> queryProductDetails() {
        return productMapper.queryProductDetails();
    }

    /**
     * 通过pid获取产品的所有详情信息
     *
     * @param pid 需要查询的产品id
     * @return 返回查询到的产品信息
     */
    @Override
    public ProductDetail queryProductDetailById(Integer pid) {
        return productMapper.queryProductDetailById(pid);
    }

    /**
     * 返回通过分页查询到的产品详情信息
     *
     * @param pageNum  查询的页码
     * @param pageSize 查询的每页数量
     * @return 返回通过分页查询到的产品详情
     */
    @Override
    public PageInfo<ProductDetail> queryProductDetailsByPage(Integer pageNum, Integer pageSize) {
        if(pageNum == null || pageSize == null) return null;
        PageHelper.startPage(pageNum, pageSize);
        List<ProductDetail> productDetails = productMapper.queryProductDetails();
        PageInfo<ProductDetail> pageInfo = new PageInfo<>(productDetails);
        return pageInfo;
    }
}

