package com.vmokrecov.apiservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfiguration {

    private static final Contact DEFAULT_CONTACT = new Contact(
            "Viktor Mokrecov", "https://github.com/vmokrecov", "v.mokrecov.ru@gmail.com");

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList(
            "application/json", "application/xml"));

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("My Title")
                .description("My Description")
                .version("1.0")
                .termsOfServiceUrl("urn:tos")
                .contact(DEFAULT_CONTACT)
                .license("MIT")
                .licenseUrl("https://github.com/300kks/api-service/blob/master/LICENSE")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
