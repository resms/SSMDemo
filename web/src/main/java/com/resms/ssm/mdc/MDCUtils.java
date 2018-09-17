package com.resms.ssm.mdc;

import org.slf4j.MDC;

public class MDCUtils {
    public static String get(String key) {
        return MDC.get(key);
    }

    public static String get(String key,String defaultValue) {
        String value = MDC.get(key);
        return value == null ? defaultValue : value;
    }

    public static String getRequestId() {
        return MDC.get(MDCConstant.MDC_KEY_REQUEST_ID);
    }

    public static String getRequestSeq() {
        return MDC.get(MDCConstant.MDC_KEY_REQUEST_SEQ);
    }

    public static String getUri() {
        return MDC.get(MDCConstant.MDC_KEY_URI);
    }

    /**
     * 获取此请求进入MDCFilter的时间戳
     * @return
     */
    public static String getTimestampOfFilter() {
        return MDC.get(MDCConstant.TIMESTAMP);
    }

    /**
     * 获取当前server的本地IP
     * @return
     */
    public static String getLocalIp() {
        return MDC.get(MDCConstant.MDC_KEY_LOCAL_IP);
    }

    public static String nextRequestSeq() {
        return MDC.get(MDCConstant.MDC_KEY_NEXT_REQUEST_SEQ);
    }

    public static String getHeader(String header) {
        return MDC.get(MDCConstant.HEADER_KEY_PREFIX + header);
    }

    public static String getParameter(String name) {
        return MDC.get(MDCConstant.PARAMETER_KEY_PREFIX + name);
    }

    public static void put(String key,String value) {
        MDC.put(key,value);
    }

    public static void clear() {
        MDC.clear();
    }

    public static void remove(String key) {
        MDC.remove(key);
    }
}
