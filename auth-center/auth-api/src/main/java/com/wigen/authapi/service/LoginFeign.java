package com.wigen.authapi.service;

import com.wigen.authapi.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangweiqing
 */
@FeignClient("auth-center")
public interface LoginFeign {

    @RequestMapping("/loginFeign/login")
    Response<String> login(@RequestParam("userName") String userName, @RequestParam("password") String password);

    @RequestMapping("/loginFeign/logOut")
    Response logOut(String userId);

    @RequestMapping("/loginFeign/verifyToken")
    Response verifyToken(String userId, String token);
}
