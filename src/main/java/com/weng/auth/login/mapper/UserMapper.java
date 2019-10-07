package com.weng.auth.login.mapper;

import com.weng.auth.login.entity.User;
import com.weng.framework.dao.mybatis.mapper.BaseMapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
 
/**
 * 用户信息 Mapper 接口
 *
 * @author 翁荟
 * @date 2019-05-20 10:11:49
 *
 */ 
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据账号查找用户信息
     *
     * @param account
     * @return
     */
    User findByUserName(@Param("account") String account);

    /*
     * 更新密码
     * @param [password, id]
     * @return
     */
    int changePwd(@Param("password") String password, @Param("id") String id);
}
