package com.ejemplo.SpringBoot.security;

import com.ejemplo.SpringBoot.Jwt.JwtTokenFilter;
import com.ejemplo.SpringBoot.repository.UsuarioRepository;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//Configuración inicial para permitir que se realicen request desde el frond sin tener que introducir usuario y clave
//Ya que Spring Boot lo solicita por usar la dependencia security web
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioRepository userRepo;
    //Creamos un  objeto del token filtro
    @Autowired
    private JwtTokenFilter jwtTokenFilter;    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Administrar si existe el usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuario ->userRepo.findByEmail(usuario)
                .orElseThrow(()-> new UsernameNotFoundException("Usur " + usuario + " not found"))
        );
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); 
    }
    
    //Actualizamos este método para que los GETs estén protegidos, que no tengan acceso publico
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Habilitamos el CORS         
         
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);        
        http.exceptionHandling().authenticationEntryPoint(
            (request, response, ex)->{
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                ex.getMessage();
            });
        http.cors().and().        
        //Aquí también podemos configurar el acceso por roles
        authorizeRequests()
                .antMatchers("/nuevo/usuario").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/ver/existe-usuario/{email}").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);              
                
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("https://app-portfolio-front-argpro.web.app"));
        configuration.setAllowedMethods(Arrays.asList("GET, POST, PUT, DELETE, OPTIONS, HEAD"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    
}
