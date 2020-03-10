package com.vmokrecov.apiservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    private ConfigProperties properties;

    @Autowired
    public SpringCloudConfig(ConfigProperties properties) {
        this.properties = properties;
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hello")
                        .uri(properties.getRest().get("helloservice") + "/hello/")
                        .id("helloService"))

                .route(r -> r.path("/world")
                        .uri(properties.getRest().get("worldservice") + "/world/")
                        .id("worldService"))

                .build();
    }
}
