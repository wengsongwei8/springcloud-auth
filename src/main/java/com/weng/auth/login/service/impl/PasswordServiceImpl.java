package com.weng.auth.login.service.impl;

import com.weng.framework.common.utils.security.password.PasswordEncoder;
import com.weng.framework.common.utils.security.password.ShaPasswordEncoder;
import com.weng.auth.login.service.PasswordService;
import org.springframework.stereotype.Service;

/**
 * @author wengzhonghui
 * @date 2019/4/15 15:09
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    PasswordEncoder passwordEncoder = new ShaPasswordEncoder();

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {

        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public String encryPassword(String rawPassword) {

        return passwordEncoder.encode(rawPassword);
    }
}
