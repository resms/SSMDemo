package com.resms.ssm.meta.mybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PermissionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    public static final Permission permission = new Permission();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.id")
    public static final SqlColumn<Long> id = permission.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_name")
    public static final SqlColumn<String> permissionName = permission.permissionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_value")
    public static final SqlColumn<String> permissionValue = permission.permissionValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.group_name")
    public static final SqlColumn<String> groupName = permission.groupName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.rank")
    public static final SqlColumn<String> rank = permission.rank;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.disable")
    public static final SqlColumn<Short> disable = permission.disable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    public static final class Permission extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> permissionName = column("permission_name", JDBCType.VARCHAR);

        public final SqlColumn<String> permissionValue = column("permission_value", JDBCType.VARCHAR);

        public final SqlColumn<String> groupName = column("group_name", JDBCType.VARCHAR);

        public final SqlColumn<String> rank = column("rank", JDBCType.VARCHAR);

        public final SqlColumn<Short> disable = column("disable", JDBCType.SMALLINT);

        public Permission() {
            super("t_permission");
        }
    }
}