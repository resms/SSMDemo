package com.resms.ssm.meta.mybatis.domain;

import com.resms.ssm.common.AbstractDomain;
import java.io.Serializable;
import javax.annotation.Generated;

/**
 *
 * table t_role_user
 *
 * @date  2020-02-19 01:28:25
 */
public class RoleUser extends AbstractDomain implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_user.role_id")
    private Long roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_user.user_id")
    private Long userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_user")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_user")
    public RoleUser(Long roleId, Long userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_user")
    public RoleUser() {
        super();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_user.role_id")
    public Long getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_user.role_id")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_user.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source field: t_role_user.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_user")
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
        RoleUser other = (RoleUser) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-02-19 01:28:25", comments="Source Table: t_role_user")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}