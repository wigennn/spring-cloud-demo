package com.wigen.auth.service;

import org.springframework.stereotype.Service;

/**
 * @author wangweiqing
 */
@Service
public class LoginService {

    private static String secretKey = "";

    public boolean verifyLoginInfo(String userName, String password) {
        // 查询数据库校验用户名密码

        return Boolean.FALSE;
    }

    public String generateToken(String userId) {
        return "";
    }

}
