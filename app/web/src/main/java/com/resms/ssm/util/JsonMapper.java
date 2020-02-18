package com.resms.ssm.util;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author sam <sam@resms.net>
 * @version 1.0.0.0
 * @ClassName JsonMapper
 * @Description TODO
 * @date 2020/2/18 19:48
 **/
public abstract class JsonMapper {

    public static String toJson(Object o){
        return "mock tojson";
    }

    public static JsonNode toJsonNode(Object o){
        return null;
    }

    public static JsonNode fromJson(String s){
        return null;
    }

    public static <T> T fromJson(String s, Class<T> clz){
        return null;
    }
}
