package com.resms.ssm.ws.soap.impl;


import com.resms.ssm.ws.soap.HelloService;

/**
 * soap webservice
 */
public class HelloServiceImpl implements HelloService {
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    public String tell(String text)
    {
        return "bolabola";
    }
}
