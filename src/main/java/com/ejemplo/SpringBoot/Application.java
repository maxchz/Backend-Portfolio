package com.ejemplo.SpringBoot;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://app-portfolio-front-argpro.web.app");
            }
        };

    }
        /*return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://app-portfolio-front-argpro.web.app");
            }
        };
    }*/
    
    /*@Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("https://app-portfolio-front-argpro.web.app"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
        configuration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Authorization","Content-Type","Accept","X-Requested-With","Access-Control-Request-Method","Access-Control-Request-Headers"));
        configuration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return  new CorsFilter(source);
    }*/

    
    
}

