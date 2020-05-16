package com.wigen.gatewaycenter.filter;

import com.alibaba.fastjson.JSON;
import com.wigen.gatewaycenter.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 18070900
 */
@Component
public class AuthGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 获取header的token
        String token = exchange.getRequest().getHeaders().getFirst("token");
        String authId = exchange.getRequest().getHeaders().getFirst("authId");
        if (verifyToken(authId, token)) {
            return chain.filter(exchange);
        }

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);

        Response data = Response.builder().code("401").message("非法请求").build();
        byte[] datas = JSON.toJSONString(data).getBytes();
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

    /**
     * 校验token
     */
    private boolean verifyToken(String authId, String token) {

        if (StringUtils.isNotEmpty(authId) && StringUtils.isNotEmpty(token)) {
            String redisToken = "token"; // from redis 根据authId获取token
            if (StringUtils.equals(redisToken, token)) {
                return true;
            }
        }

        return false;
    }
}
