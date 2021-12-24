package com.mall.service;

import com.mall.pojo.Tag;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 封装与Tag相关的service类接口
 * @date 2021/12/24 23:52
 */
public interface TagService {
    /**
     * 增加tag表中的标签
     * @param tag 需要插入的标签
     * @return 影响的行数
     */
    public Integer addTag(Tag tag);

    /**
     * 删除tag表中的标签
     * @param tid 需要删除的tag的id
     * @return 影响的行数
     */
    public Integer deleteTag(Integer tid);

    /**
     * 修改tag表中的标签
     * @param tag 需要修改的tag信息
     * @return 影响的行数
     */
    public Integer updateTag(Tag tag);

    /**
     * 获取查询到的tag标签列表
     * @return 返回查询到的tag信息列表
     */
    public List<Tag> queryTags();

    /**
     * 通过tid获取标签的所有信息
     * @param tid 需要查询的标签的id
     * @return 返回查询到的标签信息
     */
    public Tag queryTagById(Integer tid);

    /**
     * 通过tName获取产品的所有详情信息
     * @param name 需要查询的标签的id
     * @return 返回查询到的产品信息
     */
    public Tag queryTagByName(String name);
}
