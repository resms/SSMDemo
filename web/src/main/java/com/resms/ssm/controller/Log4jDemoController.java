package com.resms.ssm.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/log")
public class Log4jDemoController {
    private final Logger logger = LogManager.getLogger();

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(HttpServletRequest request, Model model) {
        logger.info("=======================info");
        logger.info("hi {}, lets play {}","sam","wow");
        return "info";
    }
}
