package com.wigen.auth.core.service;

import com.wigen.auth.security.model.LoginUser;
import com.wigen.common.exception.CostumException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
@Component
public class LoginService {

    @Resource
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    public String login(String userName, String password) {

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (AuthenticationException e) {
            throw new CostumException(e.getMessage());
        }
        LoginUser loginUser = (LoginUser) authentication.getCredentials();

        // 生成token
        return tokenService.createToken(loginUser);
    }
}
