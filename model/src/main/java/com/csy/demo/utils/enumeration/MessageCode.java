package com.csy.demo.utils.enumeration;

public enum MessageCode implements IMessageCodeEnum {
    SUCCESS(0, "成功"),
    NORMAL_ERROR(1, "普通错误"),
    SYS_ERROR(10000, "系统异常"),
    SERVICE_ERROR(20000, "业务异常"),
    OAUTH_ERROR(20001, "认证异常");

    private Integer key;
    private String value;

    private MessageCode(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
