package com.resms.ssm.meta.mybatis.mapper;

import static com.resms.ssm.meta.mybatis.mapper.RoleLocaleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.resms.ssm.common.BaseMapper;
import com.resms.ssm.meta.mybatis.domain.RoleLocale;
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
public interface RoleLocaleMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    BasicColumn[] selectList = BasicColumn.columnList(id, locale, roleName);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RoleLocale> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RoleLocale> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="locale", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="role_name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Optional<RoleLocale> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="locale", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="role_name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<RoleLocale> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, roleLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, roleLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int deleteByPrimaryKey(Long id_, String locale_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
            .and(locale, isEqualTo(locale_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int insert(RoleLocale record) {
        return MyBatis3Utils.insert(this::insert, record, roleLocale, c ->
            c.map(id).toProperty("id")
            .map(locale).toProperty("locale")
            .map(roleName).toProperty("roleName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int insertMultiple(Collection<RoleLocale> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, roleLocale, c ->
            c.map(id).toProperty("id")
            .map(locale).toProperty("locale")
            .map(roleName).toProperty("roleName")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int insertSelective(RoleLocale record) {
        return MyBatis3Utils.insert(this::insert, record, roleLocale, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(locale).toPropertyWhenPresent("locale", record::getLocale)
            .map(roleName).toPropertyWhenPresent("roleName", record::getRoleName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default Optional<RoleLocale> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, roleLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default List<RoleLocale> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, roleLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default List<RoleLocale> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, roleLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default Optional<RoleLocale> selectByPrimaryKey(Long id_, String locale_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
            .and(locale, isEqualTo(locale_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, roleLocale, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    static UpdateDSL<UpdateModel> updateAllColumns(RoleLocale record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(locale).equalTo(record::getLocale)
                .set(roleName).equalTo(record::getRoleName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RoleLocale record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(locale).equalToWhenPresent(record::getLocale)
                .set(roleName).equalToWhenPresent(record::getRoleName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int updateByPrimaryKey(RoleLocale record) {
        return update(c ->
            c.set(roleName).equalTo(record::getRoleName)
            .where(id, isEqualTo(record::getId))
            .and(locale, isEqualTo(record::getLocale))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_locale")
    default int updateByPrimaryKeySelective(RoleLocale record) {
        return update(c ->
            c.set(roleName).equalToWhenPresent(record::getRoleName)
            .where(id, isEqualTo(record::getId))
            .and(locale, isEqualTo(record::getLocale))
        );
    }
}