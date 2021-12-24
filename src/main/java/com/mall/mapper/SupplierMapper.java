package com.mall.mapper;

import com.mall.pojo.Customer;
import com.mall.pojo.Supplier;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description Supplier实体类对应的mapper层接口
 * @date 2021/12/24 18:19
 */
public interface SupplierMapper {

    /**
     * 将供应商信息添加到suppliers表中
     * @param supplier 需要添加的供应商
     * @return 返回影响的行数
     */
    public Integer addSupplier(Supplier supplier);

    /**
     * 删除供应商
     * @param supplierId 需要删除的供应商id
     * @return 返回影响的行数
     */
    public Integer deleteSupplier(Integer supplierId);

    /**
     * 更新供应商的相关信息
     * @param supplier 数据变更后的supplier对象，必须提供supplierId
     * @return 返回影响到的行数
     */
    public Integer updateSupplier(Supplier supplier);

    /**
     * 查询所有供应商信息，使用pageHelper可实现分页查询
     * @return 返回查询到的供应商的所有信息
     */
    public List<Supplier> querySuppliers();

    /**
     * 通过supplierId查询相关的供应商
     * @param supplierId 需要查询的用户id
     * @return 若存在返回客户对象，若不存在返回null
     */
    public Supplier querySupplierById(Integer supplierId);

    /**
     * 通过供应商用户名查询供应商信息
     * @param username 需要检测的用户名
     * @return 供应商实体，若不存在则返回null
     */
    public Supplier querySupplierByName(String username);
}
