package com.weng.auth.login.service.impl;

import cn.hutool.core.convert.Convert;
import com.weng.framework.core.model.ResponseData;
import com.weng.auth.login.entity.User;
import com.weng.auth.login.service.IUserService;
import com.weng.auth.security.TokenStore;
import com.weng.auth.login.service.AuthService;
import com.weng.auth.login.service.PasswordService;
import com.weng.sso.core.config.SsoConfig;
import com.weng.sso.core.model.SsoUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 认证服务
 * @author wengzhonghui
 * @date 2019/4/15 14:27
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordService passwordService;


   public ResponseData<SsoUser> login(String username, String password){
       if (StringUtils.isEmpty(username)) {
           return ResponseData.failed("UserName is empty!");
       }
       if (StringUtils.isEmpty(password)) {
           return  ResponseData.failed("Password is empty!");
       }
       User user = userService.findUser(username);
       if (user == null) {
           return ResponseData.failed("UserName or password is error!");
       }
       // 校验密码
       if(!passwordService.checkPassword(password, user.getPassword())){
           return ResponseData.failed("UserName or password is error!");
       }
       SsoUser ssoUser = Convert.convert(SsoUser.class,user);

       initByLoginType(ssoUser);
       return ResponseData.success(ssoUser);
   }

    @Override
    public ResponseData changePwd(String userName, String password, String oldPassword) {
        if (StringUtils.isEmpty(userName)) {
            return ResponseData.failed("UserName is empty!");
        }
        if (StringUtils.isEmpty(password)) {
            return  ResponseData.failed("Password is empty!");
        }
        if (StringUtils.isEmpty(oldPassword)) {
            return  ResponseData.failed("oldPassword is empty!");
        }
        User user = userService.findUser(userName);
        if (user == null) {
            return ResponseData.failed("UserName or password is error!");
        }
        // 校验密码
        if(!passwordService.checkPassword(oldPassword, user.getPassword())){
            return ResponseData.failed("UserName or password is error!");
        }
        userService.changePwd(passwordService.encryPassword(password), user.getId());

       return ResponseData.success("Password change success!");
    }

    /*
    * 根据登陆类型进行初始化
    * @param [loginType 登陆类型, ssoUser 用户信息]
    * @return
    */
    private void initByLoginType( SsoUser ssoUser){

        String token =generateToken();
        ssoUser.setToken(token);
        TokenStore.put(token, ssoUser);
        ssoUser.setFreshTime(System.currentTimeMillis());
        ssoUser.setExpireTimeLong(SsoConfig.SSO_EXPIRE_TIME_LONG);

    }

    /*
     * 生成token
     * @param []
     * @return
     */
    private String generateToken(){
        return  UUID.randomUUID().toString().replaceAll("-", "");
    }
}
