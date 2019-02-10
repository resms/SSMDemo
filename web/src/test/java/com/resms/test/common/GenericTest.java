package com.resms.test.common;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class GenericTest {

    public class GenericClass<T> { }
    public class GenericSubClass1<String> extends GenericClass<String> { }
    public class GenericSubClass2 extends GenericClass<String> { }

    @Test
    public void genericShow() {
        System.out.println("接口是否是泛型类：" + (ArrayList.class.getGenericInterfaces()[0] instanceof ParameterizedType));
        System.out.println("泛型类的名称：" + ArrayList.class.getGenericInterfaces()[0].getTypeName());
        System.out.println("泛型类的实现：" + ArrayList.class.getGenericInterfaces()[0].getClass());
        System.out.println("是否是泛型参数:" + (((ParameterizedType) ArrayList.class.getGenericInterfaces()[0]).getActualTypeArguments()[0] instanceof TypeVariable));
        System.out.println("泛型参数名称:" + ((ParameterizedType) ArrayList.class.getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName());
        System.out.println("泛型参数的实现：" + ((ParameterizedType) ArrayList.class.getGenericInterfaces()[0]).getActualTypeArguments()[0].getClass());
    }

    @Test
    public void genericRealShow() {
        Class clazz = GenericSubClass1.class;
        //Class clazz = GenericSubClass2 .class;
        // Class clazz = new GenericSubClass1().getClass();
        // Class clazz = new GenericSubClass2().getClass();
        System.out.println("父类是否是泛型类："+ (clazz.getGenericSuperclass() instanceof ParameterizedType));
        System.out.println("泛型类的名称："+ clazz.getGenericSuperclass().getTypeName());
        System.out.println("泛型类的实现："+ clazz.getGenericSuperclass().getClass());
        System.out.println("是否是泛型参数:"+(((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[0] instanceof TypeVariable));
        System.out.println("泛型参数名称:"+((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[0].getTypeName());
        System.out.println("泛型参数的实现："+((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[0].getClass());
    }
}
