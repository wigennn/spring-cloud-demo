package com.wigen.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
@RequestMapping("/auth")
public class TestController {

    @RequestMapping("/test")
    public String hello() {
        return "hello world!";
    }
}
