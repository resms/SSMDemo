package com.resms.ssm.auth.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SimpleMessage implements Serializable {
    protected String code;
    protected int ver;
    protected Date dts;
    protected String msg;

    public SimpleMessage() {
        this.ver = 1;
        this.dts = new Date();
    }

    public SimpleMessage(String code, int ver, Date dts, String msg) {
        this.code = code;
        this.ver = ver;
        this.dts = dts;
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMessage that = (SimpleMessage) o;
        return ver == that.ver &&
                Objects.equals(code, that.code) &&
                Objects.equals(dts, that.dts) &&
                Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, ver, dts, msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public Date getDts() {
        return dts;
    }

    public void setDts(Date dts) {
        this.dts = dts;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
