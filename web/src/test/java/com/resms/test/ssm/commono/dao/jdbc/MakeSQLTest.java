package com.resms.test.ssm.commono.dao.jdbc;

import com.resms.ssm.common.dao.Column;
import com.resms.ssm.common.dao.Id;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MakeSQLTest {
    public class User{
        private Long id;
        private String userName;
        private int age;
    };

    private Class<?> entityClass = User.class;

    private String getConvention(String propertyName){
        return null;
    }

    @Test
    public void testMakeSql()
    {
        System.out.println(makeInsertSql());
        System.out.println(makeUpdateSql());
        System.out.println(makeDeleteSql());
    }

    private String getTableName(Class<?> clz){
        return null;
    }

    private <T> String makeSql(T t) throws Exception{
        Class<?> clazz = t.getClass();
        //获得表名
        String tableName = getTableName(clazz);
        //获得字段
        StringBuilder fieldNames = new StringBuilder();		//字段名
        List<Object> fieldValues = new ArrayList<Object>();	//字段值
        StringBuilder placeholders = new StringBuilder();	//占位符
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),t.getClass());
            if (field.isAnnotationPresent(Id.class)) {
                fieldNames.append(field.getAnnotation(Id.class).value()).append(",");
                fieldValues.add(pd.getReadMethod().invoke(t));
            } else if(field.isAnnotationPresent(Column.class)) {
                fieldNames.append(field.getAnnotation(Column.class).value()).append(",");
                fieldValues.add(pd.getReadMethod().invoke(t));
            }
            placeholders.append("?").append(",");
        }
        //删除最后一个逗号
        fieldNames.deleteCharAt(fieldNames.length()-1);
        placeholders.deleteCharAt(placeholders.length()-1);

        //拼接sql
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName)
                .append(" (").append(fieldNames.toString())
                .append(") values (").append(placeholders).append(")") ;
//            PreparedStatement ps = JdbcDaoHelper.getConnection().prepareStatement(sql.toString());
//            //设置SQL参数占位符的值
//            setParameter(fieldValues, ps, false);
//            //执行SQL
//            ps.execute();
//            JdbcDaoHelper.release(ps, null);
//
//            System.out.println(sql + "\n" + clazz.getSimpleName() + "添加成功!");
        return null;
    }

    private String makeInsertSql(){
        StringBuffer sql = new StringBuffer();
        int loop = 0;
        Field[] fields = entityClass.getDeclaredFields();
        if (fields.length > 1) {
            loop = fields.length - 1;
            sql.append("INSERT INTO " + entityClass.getSimpleName());
            sql.append("(");
            for (int i = 0; i < loop; i++) {
                fields[i].setAccessible(true);
                String column = fields[i].getName();
                sql.append(column).append(",");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(") VALUES (");
            for (int i = 0; i < loop; i++) {
                sql.append("?,");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(")");
        }

        return sql.toString();
    }

    private String makeUpdateSql(){
        StringBuffer sql = new StringBuffer();
        int loop = 0;
        Field[] fields = entityClass.getDeclaredFields();
        if (fields.length > 1) {
            loop = fields.length - 1;
            sql.append("UPDATE " + entityClass.getSimpleName() + " SET ");
            for (int i = 0; i < loop; i++) {
                fields[i].setAccessible(true);
                String column = fields[i].getName();
                if (column.equals("id")) { // id 代表主键
                    continue;
                }
                sql.append(column).append("=").append("?,");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE id=?");
        }
        return sql.toString();
    }

    private String makeDeleteSql(){
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?");
        return sql.toString();
    }
}
