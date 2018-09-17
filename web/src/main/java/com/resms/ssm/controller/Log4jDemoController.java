package com.resms.ssm.controller;

import com.resms.ssm.demo.service.LogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/log")
public class Log4jDemoController {
    private final Logger logger = LogManager.getLogger();
    private final Logger LOG = LogManager.getFormatterLogger();
    private final Marker marker = MarkerManager.getMarker("test");
    private final org.slf4j.Logger slflogger = LoggerFactory.getLogger(Log4jDemoController.class);

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(HttpServletRequest request, Model model) {
        logger.trace("the trace level log!");
        logger.debug("the debug level log!");
        logger.info("=======================info");
        logger.info("hi {}, lets play {}","sam","wow");
        logger.warn("the warn level log!");
        logger.error("the error level log!");
        logger.fatal("the fatal level log!");

        LOG.debug("Logging in user %s with birthday %s", "sam", "1984");
        LOG.debug("Logging in user %1$s with birthday %2$tm %2$te,%2$tY", "sam", new Date());
        LOG.debug("Integer.MAX_VALUE = %,d", Integer.MAX_VALUE);
        LOG.debug("Long.MAX_VALUE = %,d", Long.MAX_VALUE);

        logger.info(marker,"the log with marker");
        LOG.info(marker,"the log with marker by %s","sam");

        slflogger.info("slf4j log bind log4j2 log");
        slflogger.info("{} log bidn {} log","slf4j","log4j2");

        logService.loadMessages();

        return "info";
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }
}