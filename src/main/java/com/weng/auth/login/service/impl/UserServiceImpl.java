package com.weng.auth.login.service.impl;

import com.weng.auth.login.entity.User;
import com.weng.auth.login.mapper.UserMapper;
import com.weng.auth.login.service.IUserService;
import com.weng.framework.dao.mybatis.service.BaseServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户信息 服务实现类
 *
 * @author 翁荟
 * @date 2019-05-20 10:11:49
 *
 */ 
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	private UserMapper userMapper;


	@Override
	public User findUser(String account) {

		return userMapper.findByUserName(account);
	}

	@Override
	public int changePwd(String password, String id) {
		return userMapper.changePwd(password,id);
	}



}
