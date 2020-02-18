package com.resms.ssm.common;

/**
 * @author sam <sam@resms.net>
 * @version 1.0.0.0
 * @ClassName Domain
 * @Description TODO
 * @date 2020/2/18 19:39
 **/
public interface Domain {

    String toJson();

    Domain fromJson(String s);
}
