package com.mall.service.impl;

import com.mall.mapper.SupplierMapper;
import com.mall.pojo.Supplier;
import com.mall.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 实现SupplierService接口
 * @date 2021/12/24 21:58
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    private SupplierMapper supplierMapper;

    @Autowired
    public void setSupplierMapper(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    /**
     * 添加供应商
     * @param supplier 需要添加的供应商
     * @return 影响的行数
     */
    @Override
    public Integer addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    /**
     * 根据供应商的id删除供应商
     * @param supplierId 需要删除的供应商编号
     * @return 影响的行数
     */
    @Override
    public Integer deleteSupplier(Integer supplierId) {
        return supplierMapper.deleteSupplier(supplierId);
    }

    /**
     * 更新供应商信息
     * @param supplier 封装更新后的数据
     * @return 影响的行数
     */
    @Override
    public Integer updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }

    /**
     * 根据供应商id查询该供应商的信息
     * @param supplierId 需要查询的供应商的id
     * @return 查询到的供应商实体
     */
    @Override
    public Supplier querySupplierById(Integer supplierId) {
        return supplierMapper.querySupplierById(supplierId);
    }

    /**
     * 通过供应商用户名查询供应商信息
     * @param username 需要检测的用户名
     * @return 供应商实体，若不存在则返回null
     */
    @Override
    public Supplier querySupplierByName(String username) {
        return supplierMapper.querySupplierByName(username);
    }

    /**
     * 查询所有的供应商
     * @return 查询到的供应商列表
     */
    @Override
    public List<Supplier> querySuppliers() {
        return supplierMapper.querySuppliers();
    }
}
