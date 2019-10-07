package com.weng.auth.login.api;

import com.weng.framework.core.model.ResponseData;
import com.weng.framework.web.base.BaseController;
import com.weng.auth.login.service.IUserService;
import com.weng.auth.security.SsoTokenLoginHelper;
import com.weng.auth.login.model.AuthReq;
import com.weng.auth.login.service.AuthService;
import com.weng.auth.security.TokenUtil;
import com.weng.sso.core.model.SsoUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author wengzhonghui
 * @date 2019/5/20 17:34
 */
@Slf4j
@RestController
@RequestMapping("/")
@Api(value = "登录相关api", tags = {"登录相关接口"})
public class AuthApi extends BaseController {

    @Autowired
    private IUserService userService;
    @Autowired
    private AuthService authService;

    @ApiOperation(value = "登录", notes = "")
    @PostMapping(value = "login")
    public ResponseData add(@Valid @RequestBody AuthReq authReq){
        return authService.login(authReq.getUserName(), authReq.getPassword());
    }

    @ApiOperation(value = "注销", notes = "")
    @PostMapping(value = "logout")
    public ResponseData logout(HttpServletRequest request){
        SsoTokenLoginHelper.logout(TokenUtil.getToken(request));
        return ResponseData.success("Logout Success!");
    }

    @ApiOperation(value = "获取用户详情", notes = "")
    @PostMapping(value = "cur-user-info")
    public ResponseData currentUserInfo(HttpServletRequest request){
        SsoUser ssoUser = SsoTokenLoginHelper.getUserInfoByToken(TokenUtil.getToken(request));
        if (ssoUser == null) {
            return  ResponseData.failed("Token is error!");
        }
        return ResponseData.success(ssoUser);
    }

}
