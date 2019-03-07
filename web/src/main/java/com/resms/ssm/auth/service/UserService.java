package com.resms.ssm.auth.service;

import com.resms.ssm.gen.mybatis.bean.User;

import java.util.List;

public interface UserService {
	User getUserById(long id);
	List<User> getUsers(List<Long> ids);
}
