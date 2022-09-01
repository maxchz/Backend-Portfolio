
package com.ejemplo.SpringBoot.Jwt;

import com.ejemplo.SpringBoot.model.Usuario;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {    
    @Autowired
    private JwtTokenUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Si el request no tiene encabzado continua con el siguiente filtro, sino salta el filtro
        if (!hasAuthorizationHeader(request)){
            filterChain.doFilter(request, response);
            return;
        }        
        String accessToken = getAccessToken(request);        
        //Si el accessToken es invalido
        if(!jwtUtil.validateAccessToken(accessToken)){
            filterChain.doFilter(request, response);
            return;
        }        
        setAuthenticationContext(accessToken, request);
        //Si todo va bien pasamos el request al último filtro         
        filterChain.doFilter(request, response);        
    }
    
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;        
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers","Content-Type, Access-Control-Headers-Allow-Headers,Authorization, X-Requested-With");
        response.setHeader("Access-Control-Max-Age", "3600");    

        /* HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;        
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers","Content-Type, Access-Control-Headers-Allow-Headers,Authorization, X-Requested-With");*/
         
        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
        logger.info(request.getRemoteAddr());
   
    }    
    
    //Si el accessToken es valido, establecemos un contexto de autentificación 
    private void setAuthenticationContext(String accessToken, HttpServletRequest request){
        UserDetails userDetails = getUserDetails(accessToken);        
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));        
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
        
    private UserDetails getUserDetails(String accessToken) {
        Usuario userDetails = new Usuario();
        String[] subjectArray = jwtUtil.getSubject(accessToken).split(",");        
        userDetails.setId(Long.parseLong(subjectArray[0]));
        userDetails.setEmail(subjectArray[1]);        
        return userDetails;
    }
    
    //Método para verificar si el request contine un encabezado de autorización
    private boolean hasAuthorizationHeader(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        //System.out.println("Authorization header: "+ header);        
        //Caso que request no contine un encabezado de autorización
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")){
            return false;
        }        
        return true;        
    }
    
    //Método para obtener el token desde el encabezado del request
    private String getAccessToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();        
        //System.out.println("Access Token: "+token);
        return token;
    }        
}
