package com.weng.auth.login.service;

import com.weng.framework.core.model.ResponseData;
import com.weng.sso.core.model.SsoUser;

/**
 * 认证服务
 * @author wengzhonghui
 * @date 2019/4/15 13:54
 */
public interface AuthService {

    /*
     * 根据账号和密码认证
     * @param [account, password, loginType]
     * @return
     */
    ResponseData<SsoUser> login(String userName, String password);

    /*
     * 修改密码
     * @param [account, password, loginType]
     * @return
     */
    ResponseData changePwd(String userName, String password, String oldPassword);
}
