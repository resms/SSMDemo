package com.resms.ssm.auth.service.impl;

import com.resms.ssm.auth.service.UserService;
import com.resms.ssm.gen.mybatis.bean.User;
import com.resms.ssm.gen.mybatis.bean.UserExample;
import com.resms.ssm.gen.mybatis.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
	private UserMapper userMapper;
	
	public User getUserById(long id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getUsers(List<Long> ids) {
		UserExample example = new UserExample();
		UserExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		return userMapper.selectByExample(example);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
