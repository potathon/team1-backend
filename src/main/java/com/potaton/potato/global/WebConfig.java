package com.potaton.potato.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "http://goldenteam.site", "https://goldenteam.site")
            .allowedOriginPatterns("*")
            .allowedHeaders("*")
            .allowCredentials(false)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
    }
}