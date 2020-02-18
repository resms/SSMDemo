package com.resms.ssm.mdc;

public abstract class MDCConstant {
    public static final String TRACE_TOKEN = "traceToken";

    public static final String REQUEST_ID_HEADER = "X-Request-ID";

    public static final String REQUEST_SEQ_HEADER = "X-Request-Seq";

    public static final String MDC_KEY_REQUEST_ID = "requestId";

    public static final String MDC_KEY_REQUEST_SEQ = "requestSeq";

    //追踪链下发时，使用的seq，由Filter生成，通常开发者不需要修改它。
    public static final String MDC_KEY_NEXT_REQUEST_SEQ = "nextRequestSeq";

    public static final String MDC_KEY_LOCAL_IP = "localIp";

    public static final String MDC_KEY_URI = "uri";

    public static final String TIMESTAMP = "_timestamp_";//进入filter的时间戳

    public static final String HEADER_KEY_PREFIX = "_HEADER_";

    public static final String PARAMETER_KEY_PREFIX = "_PARAM_";
}
