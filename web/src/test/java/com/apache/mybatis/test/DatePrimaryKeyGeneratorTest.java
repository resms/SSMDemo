package com.apache.mybatis.test;

import org.apache.mybatis.gen.impl.DateTimePrimaryKeyGeneratorImpl;
import org.junit.Test;

public class DatePrimaryKeyGeneratorTest {
    @Test
    public void testNextId()
    {
        DateTimePrimaryKeyGeneratorImpl gen = new DateTimePrimaryKeyGeneratorImpl();
        for(int i = 0; i < 1100000;i++)
            System.out.println(gen.nextId());
    }
}
