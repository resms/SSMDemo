package com.resms.common;

import org.apache.ibatis.type.TypeException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型基类，提供递归方法可以让子类获得泛型的真实类型
 *
 * @param <T>
 */
public abstract class GenericType<T> {
    private final Type parameterType;

    protected GenericType() {
        parameterType = getSuperclassTypeParameter(getClass());
    }

    private Type getSuperclassTypeParameter(Class<?> clazz) {
        //获取泛型基类类型
        Type genericSuperclass = clazz.getGenericSuperclass();
        //判断泛型基类类型是否是基础类型
        if (genericSuperclass instanceof Class) {
            //非TypeReference类型则地柜往上找
            if (GenericType.class != genericSuperclass) {
                return getSuperclassTypeParameter(clazz.getSuperclass());
            }
            //继承的第一个类不是TypeReference，则抛出异常
            throw new TypeException("'" + getClass() + "' extends GenericType and must add a type parameter to it.");
        }
        //找到泛型类型，取得泛型类型的真实类型
        Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        if (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }

        return rawType;
    }

    public final Type getParameterType() {
        return parameterType;
    }

    @Override
    public String toString() {
        return parameterType.toString();
    }
}
