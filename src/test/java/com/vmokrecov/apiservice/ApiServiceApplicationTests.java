package com.vmokrecov.apiservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"rest.helloservice=http://localhost:${wiremock.server.port}",
                      "rest.worldservice=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
class ApiServiceApplicationTests {

    private WebTestClient webClient;

    @Autowired
    ApiServiceApplicationTests(WebTestClient webClient) {
        this.webClient = webClient;
    }

    @Test
    void contextLoads() {
        stubFor(get(urlEqualTo("/hello"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"Hello\" }")));
        stubFor(get(urlEqualTo("/world"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"World\" }")));

        webClient
                .get().uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Hello");
        webClient
                .get().uri("/world")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.message").isEqualTo("World");
    }

    @Test
    void home() {
        webClient
                .get()
                .uri("/")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.message").isEqualTo("Home");
    }
}
