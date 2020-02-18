package com.resms.ssm.common.dao.jdbc.impl;

import com.resms.ssm.common.dao.jdbc.JdbcBaseDao;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.util.Assert;

/**
 * 基于JDBC的泛型Dao抽象类封装
 * @param <T>
 */
public abstract class JdbcBaseDaoImpl<T> implements JdbcBaseDao<T> {
    public static final String SQL_INSERT = "insert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_SELECT = "select";
    public static final String TBL_ALIAS = "t";

    private static final String INSERT_KW = "INSERT";
    private static final String INTO_KW = "INTO";
    private static final String VALUES_KW = "VALUES";

    private static final String UPDATE_KW = "UPDATE";
    private static final String SET_KW = "SET";

    private static final String DELETE_KW = "DELETE";
    private static final String SELECT_KW = "SELECT";
    private static final String FROM_KW = "FROM";

    private static final String WHERE_KW = "WHERE";


    private static final String INSERT_SQL_PREFIX_FMT = "INSERT INTO {0} VALUES({1})";
    private static final String UPDATE_SQL_PREFIX_FMT = "UPDATE {0} ";
    private static final String DELETE_SQL_BYID_FMT = "DELETE FROM {0} WHERE ID=?";
    private static final String SELECT_SQL_BYID_FMT = "SELECT * FROM {0} WHERE ID=?";

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private Class<T> entityClass;

    public String getEntityName(){
        if (null != entityClass)
            return entityClass.getSimpleName();

        return null;
    }

    public String getTableName(){
        String tableName = getEntityName();
        return tableName;
    }

    @SuppressWarnings("unchecked")
    public JdbcBaseDaoImpl() {
        // 获取当前new的对象的泛型的父类类型
        Type superClassType = getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) superClassType;
        // 获取第一个类型参数的真实类型
        entityClass = (Class<T>) type.getActualTypeArguments()[0];
        System.out.println("Dao实体类是：" + entityClass.getName());
    }

    @Override
    public void save(T entity) {
        String sql = makeSql(SQL_INSERT);
        Object[] args = setArgs(entity, SQL_INSERT);
        int[] argTypes = setArgTypes(entity, SQL_INSERT);
        jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public void update(T entity) {
        String sql = makeSql(SQL_UPDATE);
        Object[] args = setArgs(entity, SQL_UPDATE);
        int[] argTypes = setArgTypes(entity, SQL_UPDATE);
        jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public void delete(T entity) {
        String sql = makeSql(SQL_DELETE);
        Object[] args = setArgs(entity, SQL_DELETE);
        int[] argTypes = setArgTypes(entity, SQL_DELETE);
        jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public void deleteAll() {
        String sql = " TRUNCATE TABLE " + entityClass.getSimpleName();
        jdbcTemplate.execute(sql);
    }

    @Override
    public void delete(Serializable id) {
        String sql = " DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void batchSave(List<T> lt) {
        Assert.notEmpty(lt);
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(entityClass.getSimpleName().toLowerCase()).append("( ");
        List<Object[]> params = new ArrayList<Object[]>();
        String val = "";

        for (T t : lt) {
            int index = 0;
            Field[] fields = t.getClass().getDeclaredFields();
            if (fields != null && fields.length > 0) {
                Object[] objVal = new Object[fields.length];

                for (Field field : fields) {
                    try {
                        field.setAccessible(true);
                        Object obj = field.get(t);
                        if (params.size() == 0) {
                            sb.append(field.getName()).append(" ,");
                            val += ", ? ";
                        }
                        objVal[index++] = obj;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                params.add(objVal);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        val = val.substring(1);
        sb.append(") value (").append(val).append(")");
        String sql = sb.toString();
        jdbcTemplate.batchUpdate(sql, params);
    }

    @Override
    public void batchUpdate(List<T> lt) {
        Assert.notEmpty(lt);
        StringBuilder sb = new StringBuilder();
        sb.append("update ").append(entityClass.getSimpleName().toLowerCase()).append(" set ");
        List<Object[]> params = new ArrayList<Object[]>();
        Object primaryKey = "id";
        for (T t : lt) {
            int index = 0;
            Field[] fields = entityClass.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                Object id = null;
                Object[] objVal = new Object[fields.length];
                for (Field field : fields) {
                    try {
                        field.setAccessible(true);
                        Object obj = field.get(t);
                        if (field.getName().equalsIgnoreCase("id")) {
                            primaryKey = obj;
                            id = obj;
                        } else {
                            if (params.size() == 0) {
                                sb.append(field.getName()).append(" = ? ,");
                            }
                            objVal[index++] = obj;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    objVal[index] = id;
                }
                params.add(objVal);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" where ").append(primaryKey).append(" = ? ");
        String sql = sb.toString();
        jdbcTemplate.batchUpdate(sql, params);
    }

    @Override
    public T findById(Serializable id) {
        String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE id=?";
        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
        return jdbcTemplate.query(sql, rowMapper, id).get(0);
    }

    @Override
    public List<T> findAll() {
        String sql = "SELECT * FROM " + entityClass.getSimpleName();
        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Map<String, Object> findOne(String sql, Object... args) {
        return jdbcTemplate.queryForMap(sql, args);
    }

    @Override
    public List<Map<String, Object>> findListMap(String sql, Object... args) {
        return jdbcTemplate.queryForList(sql, args);
    }

    @Override
    public void execSQL(String sql) {
        jdbcTemplate.execute(sql);
    }

    @Override
    public SqlRowSet rowSet(String sql, Object... args) {
        return this.jdbcTemplate.queryForRowSet(sql, args);
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private String makeInsertSql(){
        StringBuffer sql = new StringBuffer();
        Field[] fields = entityClass.getDeclaredFields();
        sql.append(" INSERT INTO " + entityClass.getSimpleName());
        sql.append("(");
        for (int i = 0; fields != null && i < fields.length; i++) {
            fields[i].setAccessible(true);
            String column = fields[i].getName();
            sql.append(column).append(",");
        }
        sql = sql.deleteCharAt(sql.length() - 1);
        sql.append(") VALUES (");
        for (int i = 0; fields != null && i < fields.length; i++) {
            sql.append("?,");
        }
        sql = sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        return sql.toString();
    }

    private String makeUpdateSql(){
        StringBuffer sql = new StringBuffer();
        Field[] fields = entityClass.getDeclaredFields();
        sql.append(" UPDATE " + entityClass.getSimpleName() + " SET ");
        for (int i = 0; fields != null && i < fields.length; i++) {
            fields[i].setAccessible(true);
            String column = fields[i].getName();
            if (column.equals("id")) { // id 代表主键
                continue;
            }
            sql.append(column).append("=").append("?,");
        }
        sql = sql.deleteCharAt(sql.length() - 1);
        sql.append(" WHERE id=?");
        return sql.toString();
    }

    private String makeDeleteSql(){
        StringBuffer sql = new StringBuffer();
        sql.append(" DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?");
        return sql.toString();
    }

    /**
     * 组装SQl
     *
     * @param sqlFlag
     * @return
     */
    public String makeSql(String sqlFlag) {
        StringBuffer sql = new StringBuffer();
        Field[] fields = entityClass.getDeclaredFields();
        if (SQL_INSERT.equals(sqlFlag)) {
            sql.append(" INSERT INTO " + entityClass.getSimpleName());
            sql.append("(");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                String column = fields[i].getName();
                sql.append(column).append(",");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(") VALUES (");
            for (int i = 0; fields != null && i < fields.length; i++) {
                sql.append("?,");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(")");
        } else if (sqlFlag.equals(SQL_UPDATE)) {
            sql.append(" UPDATE " + entityClass.getSimpleName() + " SET ");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                String column = fields[i].getName();
                if (column.equals("id")) { // id 代表主键
                    continue;
                }
                sql.append(column).append("=").append("?,");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE id=?");
        } else if (sqlFlag.equals(SQL_DELETE)) {
            sql.append(" DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?");
        }
        System.out.println("SQL=" + sql);
        return sql.toString();
    }

    /**
     * 设置参数
     *
     * @param entity
     * @param sqlFlag
     * @return
     */
    public Object[] setArgs(T entity, String sqlFlag) {
        Field[] fields = entityClass.getDeclaredFields();
        if (sqlFlag.equals(SQL_INSERT)) {
            Object[] args = new Object[fields.length];
            for (int i = 0; args != null && i < args.length; i++) {
                try {
                    fields[i].setAccessible(true); // 暴力反射
                    args[i] = fields[i].get(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return args;
        } else if (sqlFlag.equals(SQL_UPDATE)) {
            Object[] tempArr = new Object[fields.length];
            for (int i = 0; tempArr != null && i < tempArr.length; i++) {
                try {
                    fields[i].setAccessible(true); // 暴力反射
                    tempArr[i] = fields[i].get(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Object[] args = new Object[fields.length];
            System.arraycopy(tempArr, 1, args, 0, tempArr.length - 1); // 数组拷贝
            args[args.length - 1] = tempArr[0];
            return args;
        } else if (sqlFlag.equals(SQL_DELETE)) {
            Object[] args = new Object[1]; // 长度是1
            fields[0].setAccessible(true); // 暴力反射
            try {
                args[0] = fields[0].get(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return args;
        }
        return null;
    }

    /**
     * 设置参数类型（写的不全，只是一些常用的）
     *
     * @param entity
     * @param sqlFlag
     * @return
     */
    public int[] setArgTypes(T entity, String sqlFlag) {
        Field[] fields = entityClass.getDeclaredFields();
        if (sqlFlag.equals(SQL_INSERT)) {
            int[] argTypes = new int[fields.length];
            try {
                for (int i = 0; argTypes != null && i < argTypes.length; i++) {
                    fields[i].setAccessible(true); // 暴力反射
                    if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
                        argTypes[i] = Types.VARCHAR;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
                        argTypes[i] = Types.DECIMAL;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
                        argTypes[i] = Types.INTEGER;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
                        argTypes[i] = Types.DATE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return argTypes;
        } else if (sqlFlag.equals(SQL_UPDATE)) {
            int[] tempArgTypes = new int[fields.length];
            int[] argTypes = new int[fields.length];
            try {
                for (int i = 0; tempArgTypes != null && i < tempArgTypes.length; i++) {
                    fields[i].setAccessible(true); // 暴力反射
                    if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
                        tempArgTypes[i] = Types.VARCHAR;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
                        tempArgTypes[i] = Types.DECIMAL;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
                        tempArgTypes[i] = Types.INTEGER;
                    } else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
                        tempArgTypes[i] = Types.DATE;
                    }
                }
                System.arraycopy(tempArgTypes, 1, argTypes, 0, tempArgTypes.length - 1); // 数组拷贝
                argTypes[argTypes.length - 1] = tempArgTypes[0];

            } catch (Exception e) {
                e.printStackTrace();
            }
            return argTypes;

        } else if (sqlFlag.equals(SQL_DELETE)) {
            int[] argTypes = new int[1]; // 长度是1
            try {
                fields[0].setAccessible(true); // 暴力反射
                if (fields[0].get(entity).getClass().getName().equals("java.lang.Long")) {
                    argTypes[0] = Types.BIGINT;
                }
                else if (fields[0].get(entity).getClass().getName().equals("java.lang.String")) {
                    argTypes[0] = Types.VARCHAR;
                } else if (fields[0].get(entity).getClass().getName().equals("java.lang.Integer")) {
                    argTypes[0] = Types.INTEGER;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return argTypes;
        }
        return null;
    }

    @Override
    public void batchDelete(Serializable[] ids) {
        String idStr="";
        for (int i = 0; i < ids.length; i++) {
            idStr+=",'"+ids[i]+"'";
        }
        String sql = " DELETE FROM " + entityClass.getSimpleName() + " WHERE id in (?)";
        jdbcTemplate.update(sql, idStr.charAt(1));
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
