package com.mall.pojo;

import java.io.Serializable;

/**
 * @author heavytiger
 * @version 1.0
 * @description Restful风格返回json的数据封装包，封装了状态码以及消息值等信息
 * @date 2021/12/23 12:00
 */
public class ResultBean<T> implements Serializable {
    private int code;       // 状态码
    private String msg;     // 消息值
    private T data;         // 返回值

    public ResultBean() {
    }

    public ResultBean(EnumResult enumResult, T data){
        this.code=enumResult.getCode();
        this.msg=enumResult.getMsg();
        this.data=data;
    }
    public ResultBean(EnumResult enumResult){
        this.code=enumResult.getCode();
        this.msg=enumResult.getMsg();
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
