package com.wigen.gatewaycenter.controller;

import com.wigen.gatewaycenter.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public Response login() {
        return Response.builder().build();
    }

    @RequestMapping("/logOut")
    public Response loginOut() {
        return Response.builder().build();
    }
}
