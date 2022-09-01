
package com.ejemplo.SpringBoot.Cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    
            @Override
            public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
                        .allowedOrigins("https://app-portfolio-front-argpro.web.app")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);
                }        
    
}
