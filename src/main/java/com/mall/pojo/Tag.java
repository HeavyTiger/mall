package com.mall.pojo;

/**
 * @author heavytiger
 * @version 1.0
 * @description Tag标签实体类，用来标记产品的种类
 * @date 2021/12/24 21:38
 */
public class Tag {
    private Integer tid;

    private Integer tName;

    public Tag() {
    }

    public Tag(Integer tid, Integer tName) {
        this.tid = tid;
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tid=" + tid +
                ", tName=" + tName +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer gettName() {
        return tName;
    }

    public void settName(Integer tName) {
        this.tName = tName;
    }
}
