package com.resms.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	/**
	 * 基本的JSP Servelet用法
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello(HttpServletResponse response) throws IOException {
		System.out.println("------------hello");
		//满满的回忆啊
		response.getWriter().print("<h1>Hello DemoSSM</h1>");
		response.flushBuffer();
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("------------welcome");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(HttpServletRequest request, Model model) {
		logger.info("=======================info");
		return "info";
	}

	@RequestMapping(value = "/none", method = RequestMethod.GET)
	public String none(HttpServletRequest request, Model model) {

		model.addAttribute("message", "this is a none message");

		logger.info("=======================none");
		return "forward:info";
	}


}