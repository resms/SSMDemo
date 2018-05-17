package com.resms.ssm.ws.rest;

import com.resms.ssm.dto.Message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/echo")
public interface EchoRestService {
    @GET
    @Path("hello")
    Message hello(String msg);
}
