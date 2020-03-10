package com.vmokrecov.apiservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("")
public class ConfigProperties {

    private Map<String, String> rest = new HashMap<>();
}
