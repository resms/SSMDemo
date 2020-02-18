package com.resms.ssm.meta.mybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RolePermissionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_permission")
    public static final RolePermission rolePermission = new RolePermission();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_permission.role_id")
    public static final SqlColumn<Long> roleId = rolePermission.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_permission.permission_id")
    public static final SqlColumn<Long> permissionId = rolePermission.permissionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_permission")
    public static final class RolePermission extends SqlTable {
        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permissionId = column("permission_id", JDBCType.BIGINT);

        public RolePermission() {
            super("t_role_permission");
        }
    }
}