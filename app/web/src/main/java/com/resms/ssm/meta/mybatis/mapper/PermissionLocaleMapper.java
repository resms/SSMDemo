package com.resms.ssm.meta.mybatis.mapper;

import static com.resms.ssm.meta.mybatis.mapper.PermissionLocaleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.resms.ssm.common.BaseMapper;
import com.resms.ssm.meta.mybatis.domain.PermissionLocale;
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
public interface PermissionLocaleMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    BasicColumn[] selectList = BasicColumn.columnList(id, locale, permissionName);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PermissionLocale> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PermissionLocale> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="locale", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="permission_name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Optional<PermissionLocale> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="locale", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="permission_name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<PermissionLocale> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, permissionLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, permissionLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int deleteByPrimaryKey(Long id_, String locale_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
            .and(locale, isEqualTo(locale_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int insert(PermissionLocale record) {
        return MyBatis3Utils.insert(this::insert, record, permissionLocale, c ->
            c.map(id).toProperty("id")
            .map(locale).toProperty("locale")
            .map(permissionName).toProperty("permissionName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int insertMultiple(Collection<PermissionLocale> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, permissionLocale, c ->
            c.map(id).toProperty("id")
            .map(locale).toProperty("locale")
            .map(permissionName).toProperty("permissionName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int insertSelective(PermissionLocale record) {
        return MyBatis3Utils.insert(this::insert, record, permissionLocale, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(locale).toPropertyWhenPresent("locale", record::getLocale)
            .map(permissionName).toPropertyWhenPresent("permissionName", record::getPermissionName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default Optional<PermissionLocale> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, permissionLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default List<PermissionLocale> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, permissionLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default List<PermissionLocale> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, permissionLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default Optional<PermissionLocale> selectByPrimaryKey(Long id_, String locale_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
            .and(locale, isEqualTo(locale_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, permissionLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    static UpdateDSL<UpdateModel> updateAllColumns(PermissionLocale record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(locale).equalTo(record::getLocale)
                .set(permissionName).equalTo(record::getPermissionName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PermissionLocale record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(locale).equalToWhenPresent(record::getLocale)
                .set(permissionName).equalToWhenPresent(record::getPermissionName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int updateByPrimaryKey(PermissionLocale record) {
        return update(c ->
            c.set(permissionName).equalTo(record::getPermissionName)
            .where(id, isEqualTo(record::getId))
            .and(locale, isEqualTo(record::getLocale))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    default int updateByPrimaryKeySelective(PermissionLocale record) {
        return update(c ->
            c.set(permissionName).equalToWhenPresent(record::getPermissionName)
            .where(id, isEqualTo(record::getId))
            .and(locale, isEqualTo(record::getLocale))
        );
    }
}