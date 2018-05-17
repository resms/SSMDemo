package com.resms.ssm.ws.soap.impl;


import com.resms.ssm.ws.soap.HelloWorld;

import javax.jws.WebService;

/**
 * soap webservice
 */
public class HelloWorldImpl implements HelloWorld {
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

    public String tell(String text)
    {
        return "bolabola";
    }
}
