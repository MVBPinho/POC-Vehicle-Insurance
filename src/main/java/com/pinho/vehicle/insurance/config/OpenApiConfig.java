package com.pinho.vehicle.insurance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("POC for a Vehicle Insurance project with Java Spring Boot JPA")
                        .version("v1")
                        .description("Some description about your API")
                        .termsOfService("https://poc_vehicle_insurance.com.br")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://poc_vehicle_insurance.com.br")
                        )
                );
    }
}
