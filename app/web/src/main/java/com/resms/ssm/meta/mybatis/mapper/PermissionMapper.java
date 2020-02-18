package com.resms.ssm.meta.mybatis.mapper;

import static com.resms.ssm.meta.mybatis.mapper.PermissionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.resms.ssm.common.BaseMapper;
import com.resms.ssm.meta.mybatis.domain.Permission;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface PermissionMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    BasicColumn[] selectList = BasicColumn.columnList(id, permissionName, permissionValue, groupName, rank, disable);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Permission> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Permission> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="permission_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="permission_value", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="group_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="rank", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="disable", javaType=Short.class, jdbcType=JdbcType.SMALLINT)
    })
    Optional<Permission> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="permission_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="permission_value", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="group_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="rank", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="disable", javaType=Short.class, jdbcType=JdbcType.SMALLINT)
    })
    List<Permission> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int insert(Permission record) {
        return MyBatis3Utils.insert(this::insert, record, permission, c ->
            c.map(id).toProperty("id")
            .map(permissionName).toProperty("permissionName")
            .map(permissionValue).toProperty("permissionValue")
            .map(groupName).toProperty("groupName")
            .map(rank).toProperty("rank")
            .map(disable).toProperty("disable")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int insertMultiple(Collection<Permission> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, permission, c ->
            c.map(id).toProperty("id")
            .map(permissionName).toProperty("permissionName")
            .map(permissionValue).toProperty("permissionValue")
            .map(groupName).toProperty("groupName")
            .map(rank).toProperty("rank")
            .map(disable).toProperty("disable")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int insertSelective(Permission record) {
        return MyBatis3Utils.insert(this::insert, record, permission, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(permissionName).toPropertyWhenPresent("permissionName", record::getPermissionName)
            .map(permissionValue).toPropertyWhenPresent("permissionValue", record::getPermissionValue)
            .map(groupName).toPropertyWhenPresent("groupName", record::getGroupName)
            .map(rank).toPropertyWhenPresent("rank", record::getRank)
            .map(disable).toPropertyWhenPresent("disable", record::getDisable)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default Optional<Permission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default List<Permission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default List<Permission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default Optional<Permission> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, permission, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    static UpdateDSL<UpdateModel> updateAllColumns(Permission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(permissionName).equalTo(record::getPermissionName)
                .set(permissionValue).equalTo(record::getPermissionValue)
                .set(groupName).equalTo(record::getGroupName)
                .set(rank).equalTo(record::getRank)
                .set(disable).equalTo(record::getDisable);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Permission record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(permissionName).equalToWhenPresent(record::getPermissionName)
                .set(permissionValue).equalToWhenPresent(record::getPermissionValue)
                .set(groupName).equalToWhenPresent(record::getGroupName)
                .set(rank).equalToWhenPresent(record::getRank)
                .set(disable).equalToWhenPresent(record::getDisable);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int updateByPrimaryKey(Permission record) {
        return update(c ->
            c.set(permissionName).equalTo(record::getPermissionName)
            .set(permissionValue).equalTo(record::getPermissionValue)
            .set(groupName).equalTo(record::getGroupName)
            .set(rank).equalTo(record::getRank)
            .set(disable).equalTo(record::getDisable)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    default int updateByPrimaryKeySelective(Permission record) {
        return update(c ->
            c.set(permissionName).equalToWhenPresent(record::getPermissionName)
            .set(permissionValue).equalToWhenPresent(record::getPermissionValue)
            .set(groupName).equalToWhenPresent(record::getGroupName)
            .set(rank).equalToWhenPresent(record::getRank)
            .set(disable).equalToWhenPresent(record::getDisable)
            .where(id, isEqualTo(record::getId))
        );
    }
}