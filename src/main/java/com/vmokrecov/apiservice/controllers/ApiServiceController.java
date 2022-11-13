package com.vmokrecov.apiservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "ApiServiceController admin", description = "ApiServiceController description")
public class ApiServiceController {

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("{ \"message\": \"Home\" }");
    }

    @GetMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("{ \"message\": \"fallback\" }");
    }
}
