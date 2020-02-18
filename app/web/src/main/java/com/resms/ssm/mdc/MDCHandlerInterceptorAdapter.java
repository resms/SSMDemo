package com.resms.ssm.mdc;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MDCHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
    /**
     * 会话ID
     */


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 放SessionId
        String sid = java.util.UUID.randomUUID().toString();
//        String sid = request.getSession().getId();

//        String uid = request.getSession().getAttribute("uid").toString();
//        uid = request.getParameter("uid");
//
//        String bid = request.getSession().getAttribute("bid").toString();
//        bid = request.getParameter("bid");

        MDC.put(MDCConstant.TRACE_TOKEN,"[BTRACE:" + sid + "]");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        // 删除
        MDC.remove(MDCConstant.TRACE_TOKEN);
    }
}
