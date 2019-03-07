package com.resms.test.plugin.mybatis;


import com.resms.plugin.mybatis.generator.impl.DateTimePrimaryKeyGeneratorImpl;

public class DatePrimaryKeyGeneratorTest {
    //@Test
    public void testNextId()
    {
        DateTimePrimaryKeyGeneratorImpl gen = new DateTimePrimaryKeyGeneratorImpl();
        for(int i = 0; i < 1100000;i++)
            System.out.println(gen.nextId());
    }
}
