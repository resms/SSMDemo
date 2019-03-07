package com.resms.plugin.mybatis;

import com.resms.plugin.mybatis.annotations.PrimaryKey;
import com.resms.plugin.mybatis.generator.PrimaryKeyGenerator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class CustomInsertKeyGeneratorPlugin implements Interceptor {

    private final static Logger logger = LoggerFactory.getLogger(CustomInsertKeyGeneratorPlugin.class);
    //默认主键id
    private static final String DEFAULT_ID_KEY = "id";
    private PrimaryKeyGenerator primaryKeyGenerator;

    public CustomInsertKeyGeneratorPlugin() {
        this.primaryKeyGenerator = null;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        for(int i = 0; i < args.length; i++) {
            Object arg = args[i];
//            String className=arg.getClass().getName();

            //第一个参数处理。根据它判断是否给“操作属性”赋值。
            if(arg instanceof MappedStatement) {//如果是第一个参数 MappedStatement
                MappedStatement ms = (MappedStatement) arg;
                SqlCommandType sqlCommandType = ms.getSqlCommandType();
                if(sqlCommandType == SqlCommandType.INSERT) {//如果是“增加”或“更新”操作，则继续进行默认操作信息赋值。否则，则退出
                    continue;
                } else {
                    break;
                }
            }

            //具体参数处理
            if(arg instanceof Map) {//如果是map，有两种情况：（1）使用@Param多参数传入，由Mybatis包装成map。（2）原始传入Map
                Map<?, ?> map = (Map<?, ?>) arg;
                for(Object object : map.values()) {
                    if(object instanceof Collection) {
                        Collection<?> collection = (Collection<?>) object;
                        //如果是集合类型,遍历
                        for(Object singleObj : collection) {
                            setProperty(singleObj);
                        }
                    } else {
                        boolean flag = setProperty(object);
                        if(flag) {
                            break;
                        }
                    }
                }
            } else {//原始参数传入
                setProperty(arg);
            }

        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 为对象的操作属性赋值
     *
     * @param object
     * @return
     */
    private boolean setProperty(Object object) throws InvocationTargetException, IllegalAccessException {

        // 根据需要，将相关属性赋上默认值
        //是否已经设置id的标志位
        boolean setFlag = false;
        String idVal;
        PrimaryKey pk = null;//AnnotationUtils.findAnnotation(object.getClass(), PrimaryKey.class);

        String idKey;
        try {
            if(pk == null) {
                idKey = DEFAULT_ID_KEY;
            } else {
                idKey = pk.value();
            }
            if(idKey != null) {
                idVal = BeanUtils.getProperty(object, idKey);
                if(idVal == null) {
                    BeanUtils.setProperty(object, idKey, primaryKeyGenerator.nextId());
                    setFlag = true;
                }
            }
        } catch(NoSuchMethodException e) {
            logger.warn("没有id的set方法", e);
        } catch(IllegalAccessException e) {
            logger.warn("设置主键发生异常", e);
        }
        return setFlag;
    }

    public void setPrimaryKeyGenerator(PrimaryKeyGenerator primaryKeyGenerator) {
        this.primaryKeyGenerator = primaryKeyGenerator;
    }
}
