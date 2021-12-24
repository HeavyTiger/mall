package com.mall.service.impl;

import com.mall.mapper.TagMapper;
import com.mall.pojo.Tag;
import com.mall.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 实现TagService接口
 * @date 2021/12/25 0:05
 */
@Service("tagService")
public class TagServiceImpl implements TagService {

    private TagMapper tagMapper;

    @Autowired
    public void setTagMapper(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    /**
     * 增加tag表中的标签
     * @param tag 需要插入的标签
     * @return 影响的行数
     */
    @Override
    public Integer addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    /**
     * 删除tag表中的标签
     * @param tid 需要删除的tag的id
     * @return 影响的行数
     */
    @Override
    public Integer deleteTag(Integer tid) {
        return tagMapper.deleteTag(tid);
    }

    /**
     * 修改tag表中的标签
     * @param tag 需要修改的tag信息
     * @return 影响的行数
     */
    @Override
    public Integer updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    /**
     * 获取查询到的tag标签列表
     * @return 返回查询到的tag信息列表
     */
    @Override
    public List<Tag> queryTags() {
        return tagMapper.queryTags();
    }

    /**
     * 通过tid获取标签的所有信息
     * @param tid 需要查询的标签的id
     * @return 返回查询到的标签信息
     */
    @Override
    public Tag queryTagById(Integer tid) {
        return tagMapper.queryTagById(tid);
    }

    /**
     * 通过tName获取产品的所有详情信息
     * @param name 需要查询的标签的名称
     * @return 返回查询到的产品信息
     */
    @Override
    public Tag queryTagByName(String name) {
        return tagMapper.queryTagByName(name);
    }
}
