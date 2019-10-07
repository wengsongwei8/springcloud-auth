package com.weng.auth.login.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wengzhonghui
 * @date 2019/4/23 13:48
 */
@Data
public class AuthReq implements Serializable {

    private static final long serialVersionUID = -8948029307193268074L;

    private String userName;
    private String password;
    private String newPassword;
    private String refreshToken;
    private String token;


}
