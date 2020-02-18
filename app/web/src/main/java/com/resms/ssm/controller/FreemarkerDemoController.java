package com.resms.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/view")
public class FreemarkerDemoController {
	private static final Logger logger = LoggerFactory.getLogger(FreemarkerDemoController.class);

	/**
	 * 基本的Freemarker用法
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		//TODO some business logic
		return "info";
	}

	/**
	 * 基本的velocity用法
	 * @throws IOException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, @RequestParam(defaultValue = "")String id) {
		//TODO some business logic
		List<String> names = new ArrayList<String>();
		names.add("sam");
		names.add("tom");

		model.addAttribute("names",names);
		return "list";
	}
}
