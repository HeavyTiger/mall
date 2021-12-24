package com.mall.pojo;

/**
 * @author heavytiger
 * @version 1.0
 * @description 状态枚举类，用来标识状态码和消息的对应关系
 * @date 2021/12/23 11:49
 */
public enum EnumResult {
    SUCCESS(200,"请求成功"),
    FAIL(400,"请求失败"),
    WRONG_UP(201,"帐号或密码错误"),
    TIME_OUT(401,"超时"),
    UNAUTHORIZED(401,"未认证（签名错误）"),
    NOT_FOUND(404,"不存在"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
    TOKEN_ERROR(701,"token已失效"),
    TOKEN_MISS(702,"token不存在");
    private int code;
    private String msg;

    EnumResult() {
    }

    EnumResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    @Override
    public String toString() {
        return "EnumResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
