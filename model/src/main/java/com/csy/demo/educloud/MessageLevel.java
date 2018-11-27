package com.csy.demo.educloud;

public enum MessageLevel {
    INFO("1", "成功"),
    WARN("2", "失败"),
    NORMAL_ERROR("2", "失败");
    public static final IMessageCodeEnum SUCCESS = IMessageCodeEnum.RED;
    private String value;
    private String key;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private MessageLevel(String value, String key) {
        this.value = value;
        this.key = key;
    }
}
