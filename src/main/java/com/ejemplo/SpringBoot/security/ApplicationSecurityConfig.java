
package com.ejemplo.SpringBoot.security;

import com.ejemplo.SpringBoot.Jwt.JwtTokenFilter;
import com.ejemplo.SpringBoot.repository.UsuarioRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//Configuracion inicial para permitir que se realicen request desde el frond sin tener que introducir usuario y clave
//Ya que Spring Boot lo solicita por usar la dependencia security web
@EnableWebSecurity
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

    //Administrat si existe el usuario
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
        http.csrf().disable();
        //Habilitamos el CORS
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.exceptionHandling().authenticationEntryPoint(
            (request, response, ex)->{
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                ex.getMessage();
            });
        
        //Aquí también podemos configurar el acceso por roles
        http.authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .anyRequest().authenticated();
        
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    
    
}