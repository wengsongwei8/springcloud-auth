package com.weng.auth.login.service;

import com.weng.auth.login.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import org.apache.ibatis.annotations.Param;


/**
 * 用户信息 服务接口
 *
 * @author 翁荟
 * @date 2019-05-20 10:11:49
 *
 */  
public interface IUserService extends IService<User> {




	/*
	 * 根据账号查找用户
	 * @param [account]
	 * @return
	 */
	User findUser(String account);


	/*
	 * 更新密码
	 * @param [password, id]
	 * @return
	 */
	int changePwd(@Param("password") String password, @Param("id") String id);



}
