package com.resms.ssm.demo.service;

import com.resms.ssm.auth.dto.SimpleMessage;

import java.util.List;

public interface LogService {
    public List<SimpleMessage> loadMessages();
}
