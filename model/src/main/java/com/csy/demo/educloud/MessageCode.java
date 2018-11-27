package com.csy.demo.educloud;

public enum MessageCode {
    SCUUESS("1", "成功"),
    SYS_ERROR("2", "失败"),
    NORMAL_ERROR("2", "失败");

    public static final IMessageCodeEnum SUCCESS =IMessageCodeEnum.RED ;
    private String value;
    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private MessageCode(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
