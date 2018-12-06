package com.csy.demo.utils;

import com.csy.demo.utils.enumeration.IMessageCodeEnum;
import com.csy.demo.utils.enumeration.MessageCode;
import com.csy.demo.utils.enumeration.MessageLevel;

public class SimpleMessage extends BasicMessage {
    private String level;
    private boolean showHits;

    public SimpleMessage() {
    }

    private SimpleMessage(IMessageCodeEnum code, Object data, MessageLevel level, String message, boolean showHits) {
        super(code, data, message);
        this.level = level.getKey();
        this.showHits = showHits;
    }

    private SimpleMessage(IMessageCodeEnum code, MessageLevel level, String message, boolean showHits) {
        super(code, message);
        this.level = level.getKey();
        this.showHits = showHits;
    }

    public static SimpleMessage info(String message) {
        return new SimpleMessage(MessageCode.SUCCESS, MessageLevel.INFO, message, true);
    }

    public static SimpleMessage info(String message, boolean showHits) {
        return new SimpleMessage(MessageCode.SUCCESS, MessageLevel.INFO, message, showHits);
    }

    public static SimpleMessage info(Object data) {
        return new SimpleMessage(MessageCode.SUCCESS, data, MessageLevel.INFO, "", false);
    }

    public static SimpleMessage info(String message, Object data) {
        return new SimpleMessage(MessageCode.SUCCESS, data, MessageLevel.INFO, message, true);
    }

    public static SimpleMessage info(IMessageCodeEnum code, Object data) {
        return new SimpleMessage(code, data, MessageLevel.INFO, (String)code.getValue(), false);
    }

    public static SimpleMessage warn(String message) {
        return new SimpleMessage(MessageCode.NORMAL_ERROR, MessageLevel.WARN, message, true);
    }

    public static SimpleMessage warn(Object data) {
        return new SimpleMessage(MessageCode.NORMAL_ERROR, data, MessageLevel.WARN, "", false);
    }

    public static SimpleMessage warn(IMessageCodeEnum code) {
        return new SimpleMessage(code, "", MessageLevel.WARN, (String)code.getValue(), true);
    }

    public static SimpleMessage warn(String message, Object data) {
        return new SimpleMessage(MessageCode.NORMAL_ERROR, data, MessageLevel.WARN, message, true);
    }

    public static SimpleMessage warn(IMessageCodeEnum code, Object data) {
        return new SimpleMessage(code, data, MessageLevel.WARN, (String)code.getValue(), true);
    }

    public static SimpleMessage fail(String message) {
        return new SimpleMessage(MessageCode.SYS_ERROR, MessageLevel.FAIL, message, true);
    }

    public static SimpleMessage fail(IMessageCodeEnum code) {
        return new SimpleMessage(code, MessageLevel.FAIL, (String)code.getValue(), true);
    }

    public static SimpleMessage fail(IMessageCodeEnum code, String message) {
        return new SimpleMessage(code, MessageLevel.FAIL, message, true);
    }

    public static SimpleMessage fail(IMessageCodeEnum code, Object data) {
        return new SimpleMessage(code, data, MessageLevel.FAIL, (String)code.getValue(), true);
    }

    public static SimpleMessage fail(IMessageCodeEnum code, String message, Object data) {
        return new SimpleMessage(code, data, MessageLevel.FAIL, message, true);
    }

    public String getLevel() {
        return this.level;
    }

    public boolean isShowHits() {
        return this.showHits;
    }
}
