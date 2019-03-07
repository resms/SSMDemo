package com.resms.plugin.mybatis;

import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class CreateUpdateTimePlugin implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(CreateUpdateTimePlugin.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		try {
			MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
	        
	        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
	        Object parameter = invocation.getArgs()[1];
	        
	        if (SqlCommandType.INSERT.equals(sqlCommandType)) { // insert 语句插入 createTime, updateTime
	        	MetaObject metaObject = SystemMetaObject.forObject(parameter);
	        	if (metaObject.hasSetter("createTime")){
	        		metaObject.setValue("createTime", new Date());
	        	}
				if (metaObject.hasSetter("updateTime")){
	        		metaObject.setValue("updateTime", new Date());
				}
	           
	        }
	        if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
	        	 // update 语句插入 updateTime
	        	MetaObject metaObject = SystemMetaObject.forObject(parameter);
	        	if (metaObject.hasSetter("updateTime")) {
					metaObject.setValue("updateTime", new Date());
				}
	        }
		} catch (Exception e) {
			logger.error("auto insert or update createTime or updateTime fail",e);
		}		

        return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}

   
}
