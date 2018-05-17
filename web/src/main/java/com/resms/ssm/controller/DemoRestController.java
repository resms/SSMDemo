package com.resms.ssm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.resms.ssm.dto.Message;

@RestController
@RequestMapping(value = "/rest")
public class DemoRestController {

	@RequestMapping(value = "/data/{id}", method = { RequestMethod.GET })
	public JsonNode json(@PathVariable String id) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("opCode", "1");
		node.put("text", "get data by id=" + id);
		return node;
	}

	@RequestMapping(value = "/hi/{player}", method = { RequestMethod.GET })
	public Message message(@PathVariable String player) {
		Message msg = new Message("1","hi " + player,"blabla");
		return msg;
	}
}
