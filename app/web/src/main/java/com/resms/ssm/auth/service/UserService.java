package com.resms.ssm.auth.service;

import com.resms.ssm.gen.mybatis.bean.User;

import java.util.List;

public interface UserService {
	User getUserById(long id);
	List<User> getUsers(List<Long> ids);
	int save(User u);
	int save1(User u) throws Exception;
	int update(User u);
	int delete(User u);
	int delete(Long id);
}
