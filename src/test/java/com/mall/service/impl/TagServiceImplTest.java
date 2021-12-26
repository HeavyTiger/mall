package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.pojo.Supplier;
import com.mall.pojo.Tag;
import com.mall.service.TagService;
import com.mall.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.UUID;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 测试TagService中的方法是否工作正常
 * @date 2021/12/25 0:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
@WebAppConfiguration("src/main/resources")
public class TagServiceImplTest {

    @Autowired
    private TagService tagService;

    @Test
    public void testAddTag() {
        for (int i = 0; i < 5; i++) {
            Tag tag = new Tag(null, "test" + i);
            System.out.println(tagService.addTag(tag));
            System.out.println("插入的tag主键id为" + tag.getTid());
        }
    }

    @Test
    public void testDeleteTag() {
        System.out.println(tagService.deleteTag(12));
    }

    @Test
    public void testUpdateTag() {
        for (int i = 0; i < 4; i++) {
            Tag tag = new Tag(i + 8, "update" + i);
            System.out.println(tag);
            System.out.println(tagService.updateTag(tag));
        }
    }

    @Test
    public void testQueryTags() {
        for (Tag tag : tagService.queryTags()) {
            System.out.println(tag);
        }
    }

    @Test
    public void testQueryTagById() {
        System.out.println(tagService.queryTagById(5));
        System.out.println(tagService.queryTagById(50));
    }

    @Test
    public void testQueryTagByName() {
        System.out.println(tagService.queryTagByName("手机"));
    }

    @Test
    public void testQueryTagByPage() {
        PageHelper.startPage(3, 4);
        List<Tag> tags = tagService.queryTags();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        System.out.println(JsonUtil.objToJson(pageInfo));
    }
}
