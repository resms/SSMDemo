package com.resms.ssm.dto;

import java.io.Serializable;

public class Message implements Serializable {
    protected final String code;
    protected final String content;
    protected final String msg;

    public Message(String code, String content, String msg) {
        this.code = code;
        this.content = content;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    public String getMsg() {
        return msg;
    }
}
