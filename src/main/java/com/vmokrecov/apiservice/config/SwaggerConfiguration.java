package com.vmokrecov.apiservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    private static final Contact DEFAULT_CONTACT = new Contact()
            .name("Viktor Mokrecov")
            .url("https://github.com/vmokrecov")
            .email("v.mokrecov.ru@gmail.com");

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My Title")
                        .description("My Description")
                        .version("1.0")
                        .contact(DEFAULT_CONTACT)
                        .license(new License().name("MIT").url("https://github.com/300kks/worldservice/blob/master/LICENSE")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }
}
