package com.resms.ssm.test;

import org.junit.Test;

import java.util.Map;

public class OSEnvTest {
    @Test
    public void disply()
    {
        for(Map.Entry<String,String> entry : System.getenv().entrySet())
        {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
