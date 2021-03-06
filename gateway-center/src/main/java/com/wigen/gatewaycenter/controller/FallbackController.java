package com.wigen.gatewaycenter.controller;

import com.wigen.gatewaycenter.Response;
import com.wigen.gatewaycenter.common.ResponseCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public Response fallback() {
        return Response.builder().code(ResponseCode.FAILED).message("服务暂时不可用").build();
    }
}
