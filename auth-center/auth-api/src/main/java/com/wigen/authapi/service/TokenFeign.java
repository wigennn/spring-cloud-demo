package com.wigen.authapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 18070900
 */
@FeignClient("auth-center")
public interface TokenFeign {

    @RequestMapping("/generateToken")
    String generateToken();
}
