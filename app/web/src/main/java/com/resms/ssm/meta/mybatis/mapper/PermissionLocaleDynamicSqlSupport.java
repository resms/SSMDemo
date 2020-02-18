package com.resms.ssm.meta.mybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PermissionLocaleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    public static final PermissionLocale permissionLocale = new PermissionLocale();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission_locale.id")
    public static final SqlColumn<Long> id = permissionLocale.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission_locale.locale")
    public static final SqlColumn<String> locale = permissionLocale.locale;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission_locale.permission_name")
    public static final SqlColumn<String> permissionName = permissionLocale.permissionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission_locale")
    public static final class PermissionLocale extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> locale = column("locale", JDBCType.VARCHAR);

        public final SqlColumn<String> permissionName = column("permission_name", JDBCType.VARCHAR);

        public PermissionLocale() {
            super("t_permission_locale");
        }
    }
}