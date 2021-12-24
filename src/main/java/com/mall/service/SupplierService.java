package com.mall.service;

import com.mall.pojo.Supplier;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 封装与Supplier相关的service类接口
 * @date 2021/12/24 19:14
 */
public interface SupplierService {
    /**
     * 添加供应商
     * @param supplier 需要添加的供应商
     * @return 返回影响的行数
     */
    public Integer addSupplier(Supplier supplier);

    /**
     * 根据供应商的id删除供应商
     * @param supplierId 需要删除的供应商编号
     * @return 返回影响的行数 这是AntonyCJ修改的
     */
    public Integer deleteSupplier(Integer supplierId);

    /**
     * 更新供应商信息
     * @param supplier 封装更新后的数据
     * @return 影响的行数
     */
    public Integer updateSupplier(Supplier supplier);

    /**
     * 根据供应商的id查询全部信息
     * @param supplierId 需要查询的供应商的id
     * @return 返回查询到的供应商的实体
     */
    public Supplier querySupplierById(Integer supplierId);

    /**
     * 查询供应商的用户名是否存在
     * @param username 需要查找的用户名
     * @return 查询到的结果
     */
    public Supplier querySupplierByName(String username);

    /**
     * 查询所有的供应商
     * @return 返回查询到的供应商列表
     */
    public List<Supplier> querySuppliers();
}
