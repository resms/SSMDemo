package com.resms.ssm.gen.mybatis.bean;

import java.io.Serializable;

/**
 *
 * table t_user
 *
 * @date  2019-03-11 21:39:31
 */
public class User implements Serializable {
    /**
     *
     * column t_user.id
     */
    private Long id;

    /**
     *
     * column t_user.user_name
     */
    private String userName;

    /**
     *
     * column t_user.password
     */
    private String password;

    /**
     *
     * column t_user.age
     */
    private Integer age;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public User(Long id, String userName, String password, Integer age) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    /**
     *
     */
    public User() {
        super();
    }

    /**
     *
     * @return the value of t_user.id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id the value for t_user.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the value of t_user.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName the value for t_user.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @return the value of t_user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password the value for t_user.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *
     * @return the value of t_user.age
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age the value for t_user.age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     */
    @Override
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        return result;
    }
}