package com.resms.ssm.common;

import com.resms.ssm.util.JsonMapper;

public abstract class AbstractDomain implements Domain {
    @Override
    public String toJson(){
        return JsonMapper.toJson(this);
    }

    @Override
    public AbstractDomain fromJson(String s){
        return JsonMapper.fromJson(s,this.getClass());
    }
}
