package com.resms.ssm.meta.mybatis.domain;

import com.resms.ssm.common.AbstractDomain;
import java.io.Serializable;
import javax.annotation.Generated;

/**
 *
 * table t_permission
 *
 * @date  2020-02-19 01:28:25
 */
public class Permission extends AbstractDomain implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_name")
    private String permissionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_value")
    private String permissionValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.group_name")
    private String groupName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.rank")
    private String rank;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.disable")
    private Short disable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    public Permission(Long id, String permissionName, String permissionValue, String groupName, String rank, Short disable) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionValue = permissionValue;
        this.groupName = groupName;
        this.rank = rank;
        this.disable = disable;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    public Permission() {
        super();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_name")
    public String getPermissionName() {
        return permissionName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_name")
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_value")
    public String getPermissionValue() {
        return permissionValue;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.permission_value")
    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue == null ? null : permissionValue.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.group_name")
    public String getGroupName() {
        return groupName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.group_name")
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.rank")
    public String getRank() {
        return rank;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.rank")
    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.disable")
    public Short getDisable() {
        return disable;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_permission.disable")
    public void setDisable(Short disable) {
        this.disable = disable;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermissionName() == null ? other.getPermissionName() == null : this.getPermissionName().equals(other.getPermissionName()))
            && (this.getPermissionValue() == null ? other.getPermissionValue() == null : this.getPermissionValue().equals(other.getPermissionValue()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()))
            && (this.getDisable() == null ? other.getDisable() == null : this.getDisable().equals(other.getDisable()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_permission")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPermissionName() == null) ? 0 : getPermissionName().hashCode());
        result = prime * result + ((getPermissionValue() == null) ? 0 : getPermissionValue().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        result = prime * result + ((getDisable() == null) ? 0 : getDisable().hashCode());
        return result;
    }
}