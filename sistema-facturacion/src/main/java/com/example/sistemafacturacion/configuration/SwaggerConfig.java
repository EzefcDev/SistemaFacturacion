package com.example.sistemafacturacion.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("0.0.1-SNAPSHOT") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Facturación")
                        .version(appVersion)
                        .description("Sistema de facturación para entrega final de coderhouse "));
    }


}
