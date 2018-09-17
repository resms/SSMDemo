package org.apache.mybatis.gen.impl;


import org.apache.mybatis.gen.PrimaryKeyGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 20位数字，前14位时间，到秒，后6位流水号
 */
public class DateTimePrimaryKeyGeneratorImpl implements PrimaryKeyGenerator {

    private static final Long SEED_VALUE = 1000000L;//保证后6位不重复
    private static final Long SAFE_MAX_VALUE = Long.MAX_VALUE - 1;
    private volatile AtomicLong currentVal = new AtomicLong(SEED_VALUE);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMss");

    @Override
    public String nextId() {        
        String prefix = sdf.format(new Date(System.currentTimeMillis()));//每秒的时间值
        String num = "" + currentVal.incrementAndGet();
        num = num.substring(num.length() - 6);
        if(currentVal.get() >= SAFE_MAX_VALUE) {
            currentVal = new AtomicLong(SEED_VALUE);
        }
        //时间到秒(14位)+顺序号(6位) , 单台机器每秒钟最大10W
        return prefix + num;
    }
}
