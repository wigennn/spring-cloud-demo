package com.wigen.auth.controller;

import com.wigen.auth.service.LoginService;
import com.wigen.authapi.Response;
import com.wigen.authapi.service.LoginFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangweiqing
 */
@RestController
public class LoginController implements LoginFeign {

    @Autowired
    LoginService loginService;

    @Override
    public Response<String> login(String userName, String password) {
        Response<String> response = new Response<>();

        // 1.校验用户名密码
        boolean verifyResult = loginService.verifyLoginInfo(userName, password);

        // 2.生成token
        if (verifyResult) {
            String token = loginService.generateToken(userName);
            response.setData(token);
        } else {
            response.setCode("");
            response.setMessage("校验用户名密码失败");
        }

        return response;
    }

    @Override
    public Response logOut(String userId) {
        // 根据userId 使token 失效

        return null;
    }

    @Override
    public Response verifyToken(String userId, String token) {
        return null;
    }
}
