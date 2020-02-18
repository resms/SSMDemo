package com.resms.ssm.ws.rest.impl;

import com.resms.ssm.dto.Message;
import com.resms.ssm.ws.rest.EchoRestService;

public class EchoRestServiceImpl implements EchoRestService {

    public Message hello(String msg)
    {
        return new Message("1","hello","");
    }
}
