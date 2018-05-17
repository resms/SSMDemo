package com.resms.ssm.ws.soap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * soap webservice
 */
@WebService(targetNamespace = "com.resms.webservice")
public interface HelloWorld {
    @WebResult(name = "result")
    String sayHi(@WebParam(name = "who") String text);
}
