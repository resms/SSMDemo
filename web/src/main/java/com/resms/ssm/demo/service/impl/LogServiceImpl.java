package com.resms.ssm.demo.service.impl;

import com.resms.ssm.auth.dto.SimpleMessage;
import com.resms.ssm.demo.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    public List<SimpleMessage> loadMessages()
    {
        logger.info("test btrace log!");
        return null;
    }
}
