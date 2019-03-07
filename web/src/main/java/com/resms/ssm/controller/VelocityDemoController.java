package com.resms.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/vm")
public class VelocityDemoController {
	private static final Logger logger = LoggerFactory.getLogger(VelocityDemoController.class);

	/**
	 * 基本的velocity用法
	 * @throws IOException
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() throws IOException {
		//TODO some business logic
		return "velocity";
	}
}
