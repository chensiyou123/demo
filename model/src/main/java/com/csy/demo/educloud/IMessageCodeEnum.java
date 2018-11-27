package com.csy.demo.educloud;

/**
 * 日志表的action字段
 * Created by BlueT on 2017/3/4.
 */
public enum IMessageCodeEnum {
    RED(1),
    AA(2);
    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    IMessageCodeEnum(Integer key) {
        this.key = key;
    }
}
