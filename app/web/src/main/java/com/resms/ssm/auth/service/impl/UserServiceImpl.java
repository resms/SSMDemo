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
		logger.info("getUserById=" + id);
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getUsers(List<Long> ids) {
		UserExample example = new UserExample();
		UserExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		return userMapper.selectByExample(example);
	}

	public int save(User u){
		return userMapper.insert(u);
	}

	public int save1(User u) throws Exception {
		func(u);
		return 0;
	}
	private void func(User u) throws Exception {
		userMapper.insert(u);
		throw new Exception("test private method transaction");
	}
	public int update(User u){
		return userMapper.updateByPrimaryKey(u);
	}

	public int delete(User u){
		return userMapper.deleteByPrimaryKey(u.getId());
	}

	public int delete(Long id){
		return userMapper.deleteByPrimaryKey(id);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
