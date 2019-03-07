package com.resms.plugin.mybatis.generator.impl;


import com.resms.plugin.mybatis.generator.PrimaryKeyGenerator;

import java.util.concurrent.atomic.AtomicLong;


public class CustomPrimaryKeyGeneratorImpl implements PrimaryKeyGenerator {

    private volatile AtomicLong currentVal = new AtomicLong(1000000L);//从1000000开始能保证有7位，可以截取后小于7位顺序号。

    @Override
    public String nextId() {        
        String prefix = String.valueOf(System.currentTimeMillis() / 60000);//每分钟的时间值
        String sVal = ""+currentVal.incrementAndGet();
        sVal= sVal.substring(sVal.length()-6);
        //时间到分钟(8位)+机器码(2位)+顺序号(6位) , 单台机器每分钟最大100W
        return prefix+sVal;
    }
}
