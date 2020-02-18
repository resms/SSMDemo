package com.resms.ssm.meta.mybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role")
    public static final Role role = new Role();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role.id")
    public static final SqlColumn<Long> id = role.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role.role_name")
    public static final SqlColumn<String> roleName = role.roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role")
    public static final class Role extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public Role() {
            super("t_role");
        }
    }
}