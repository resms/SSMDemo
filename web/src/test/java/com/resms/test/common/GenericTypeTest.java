package com.resms.test.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenericTypeTest {


    @Test
    public void getRealType(){
        ThingService service = new ThingServiceImpl();
        assertEquals("must be Thing","Thing",((ThingServiceImpl) service).getParameterType().toString());

    }

    @Test
    public void getExtRealType(){
        ExtThingService service = new ExtThingServiceImpl();
        assertEquals("must be Thing","Thing",((ExtThingServiceImpl) service).getParameterType().toString());
    }
}
