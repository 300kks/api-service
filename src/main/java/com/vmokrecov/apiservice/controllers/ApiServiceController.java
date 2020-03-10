package com.vmokrecov.apiservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
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
