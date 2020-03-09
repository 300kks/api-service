package com.vmokrecov.apiservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hello")
                        .uri("http://helloservice:8081/hello/")
                        .id("helloService"))

                .route(r -> r.path("/world")
                        .uri("http://worldservice:8082/world/")
                        .id("worldService"))

                .build();
    }
}
