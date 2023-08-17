package com.api.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/users/**").uri("http://localhost:8080/api/users"))
                .route(r -> r.path("/api/orders/**").uri("http://localhost:8081/api/orders"))
                .build();
    }
}
