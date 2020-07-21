package com.wigen.auth.core.controller;

import com.wigen.auth.constant.Constants;
import com.wigen.auth.core.domain.LoginDTO;
import com.wigen.auth.core.service.LoginService;
import com.wigen.common.resp.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@RestController
@RequestMapping("/auth-center")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public Result login(LoginDTO loginDTO) {
        Result result = new Result();
        String token = loginService.login(loginDTO.getUserName(), loginDTO.getPassword());

        result.put(Constants.TOKEN, token);

        // redis

        return result;
    }
}
