package com.resms.ssm.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resms.ssm.auth.service.UserService;
import com.resms.ssm.gen.mybatis.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/rest/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = { RequestMethod.GET })
    public JsonNode json(@PathVariable String id) throws IOException {
        logger.debug("============req id is " + id);

        ObjectMapper mapper = new ObjectMapper();
        User user = userService.getUserById(Long.parseLong(id));

        String jsonText = mapper.writeValueAsString(user);

        JsonNode node = mapper.readValue(jsonText,JsonNode.class);

        return node;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}