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
                .route(r -> r.path("/oauth/token")
                        .uri("http://localhost:8090/oauth/token")
                        .id("auth"))

                .route(r -> r.path("/hello")
                        .filters(f -> f.circuitBreaker(c -> c.setName("helloserviceCircuitBreaker")
                                .setFallbackUri("/fallback")))
                        .uri(properties.getRest().get("helloservice") + "/hello")
                        .id("helloService"))

                .route(r -> r.path("/world")
                        .filters(f -> f.circuitBreaker(c -> c.setName("worldserviceCircuitBreaker")
                                .setFallbackUri("/fallback")))
                        .uri(properties.getRest().get("worldservice") + "/world")
                        .id("worldService"))

                .route(r -> r.path("/helloworld")
                        .filters(f -> f.circuitBreaker(c -> c.setName("helloworldserviceCircuitBreaker")
                                .setFallbackUri("/fallback")))
                        .uri(properties.getRest().get("helloworldservice") + "/helloworld")
                        .id("helloworldService"))

                .build();
    }
}
