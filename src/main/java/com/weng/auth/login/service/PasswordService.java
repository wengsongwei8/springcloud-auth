package com.weng.auth.login.service;

/*
 *  密码服务
 * @author wengzhonghui
 * @date 15:10 2019/4/15
 */
public interface PasswordService {

    /*
     * 检查密码是否正确
     * @param [rawPassword 原始密码, encodedPassword 加密过的密码]
     * @return
     */
     boolean checkPassword(String rawPassword, String encodedPassword);

     /*
      * 对密码进行加密码
      * @param [rawPassword]
      * @return
      */
     String encryPassword(String rawPassword);
}
