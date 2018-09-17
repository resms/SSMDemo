package com.resms.ssm.mdc;

import com.resms.ssm.mdc.MDCConstant;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 *
 * 注意，此Filter尽可能的放在其他Filter之前
 *
 * 在layout部分，通过%X{key}的方式使用MDC中的变量
 */
public class MDCFilter implements Filter {

    /**
     * 是否开启headers映射，如果开启，将可以在logback中使用
     * %X{_HEADER_:<header>}来打印此header,比如：%X{_HEADER_:X-Forwarded-For}
     * 如果开启此参数，还可以使用如下格式打印所有的headers列表:
     * 格式为：key:value,key:value
     * %X{requestHeaders}
     */
    private boolean mappedHeaders;

    /**
     * 是否开启parameters映射，此parameters可以为Get的查询字符串，可以为post的Form Entries
     * %X{_PARAM_:<parameter>}来答应此参数值，比如：%X{_PARAM_:id}
     * 如果开启此参数，还可以使用如下格式打印所有的headers列表:
     * 格式为：key:value,key:value
     * %X{requestParameters}
     */
    private boolean mappedParameters;

    private String localIp;//本机IP


    //all headers,content as key:value,key:value
    private static final String HEADERS_CONTENT = "requestHeaders";

    //all parameters
    private static final String PARAMETERS_CONTENT = "requestParameters";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mappedHeaders = Boolean.valueOf(filterConfig.getInitParameter("mappedHeaders"));
        mappedParameters = Boolean.valueOf(filterConfig.getInitParameter("mappedParameters"));
        //getLocalIp
        localIp = getLocalIp();
    }

    private String getLocalIp() {
        try {
            //一个主机有多个网络接口
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = netInterfaces.nextElement();
                //每个网络接口,都会有多个"网络地址",比如一定会有loopback地址,会有siteLocal地址等.以及IPV4或者IPV6    .
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    //get only :172.*,192.*,10.*
                    if (address.isSiteLocalAddress() && !address.isLoopbackAddress()) {
                        return address.getHostAddress();
                    }
                }
            }
        }catch (Exception e) {
            //
        }
        return null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        try {
            mdc(httpRequest);
        } catch (Exception e) {
            //
        }

        try {
            chain.doFilter(request,response);
        } finally {
            MDC.clear();//must be,threadLocal
        }

    }

    private void mdc(HttpServletRequest httpRequest) {
        MDC.put(MDCConstant.MDC_KEY_LOCAL_IP,localIp);

        MDC.put(MDCConstant.MDC_KEY_REQUEST_ID,httpRequest.getHeader(MDCConstant.REQUEST_ID_HEADER));

        String requestSeq = httpRequest.getHeader(MDCConstant.REQUEST_SEQ_HEADER);
        if(requestSeq != null) {
            String nextSeq = requestSeq + "0";//seq will be like:000,real seq is the number of "0"
            MDC.put(MDCConstant.MDC_KEY_NEXT_REQUEST_SEQ,nextSeq);
        }else {
            MDC.put(MDCConstant.MDC_KEY_NEXT_REQUEST_SEQ,"0");
        }
        MDC.put(MDCConstant.MDC_KEY_REQUEST_SEQ,requestSeq);
        MDC.put(MDCConstant.TIMESTAMP,"" + System.currentTimeMillis());
        MDC.put(MDCConstant.MDC_KEY_URI,httpRequest.getRequestURI());

        if(mappedHeaders) {
            Enumeration<String> e = httpRequest.getHeaderNames();
            if(e != null) {
                //
                while (e.hasMoreElements()) {
                    String header = e.nextElement();
                    String value = httpRequest.getHeader(header);
                    MDC.put(MDCConstant.HEADER_KEY_PREFIX + header, value);
                    //
                }

            }
        }

        if(mappedParameters) {
            Enumeration<String> e = httpRequest.getParameterNames();
            if(e != null) {
                //
                while (e.hasMoreElements()) {
                    String key = e.nextElement();
                    String value = httpRequest.getParameter(key);
                    MDC.put(MDCConstant.PARAMETER_KEY_PREFIX + key,value);
                    //
                }

            }
        }
    }

    @Override
    public void destroy() {

    }
}
