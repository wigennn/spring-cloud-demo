package com.wigen.gatewaycenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class GatewayCenterApplication {

    @Value("${authUri:localhost:3000}")
    private String authUri;

    public static void main(String[] args) {
        SpringApplication.run(GatewayCenterApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-center", predicateSpec -> predicateSpec.order(0)
                        .path("/auth/**").uri(authUri))
                .build();
    }
}
