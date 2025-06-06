package com.example.qr_backend.config.swagger;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

@Log4j2
@Configuration
public class Swagger3Config implements WebMvcConfigurer {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${spring.application.description}")
    private String applicationDescription;
    @Value("${spring.application.version}")
    private String applicationVersion;

    @Bean
    public OpenAPI customizeOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title(applicationName)
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .contact(new Contact()
                                .name("WOW Finstack")
                                .email("info@wowfinstack.com")
                                .url("https://www.wowfinstack.com/"))
                        .termsOfService("Terms of Service")
                        .license(new License()
                                .name("License of API")
                                .url("API License URL"))
                        .extensions(Collections.emptyMap()))
                .servers(List.of(
                        new Server().url("http://170.187.232.199:9090").description("Remote Development Server")));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
