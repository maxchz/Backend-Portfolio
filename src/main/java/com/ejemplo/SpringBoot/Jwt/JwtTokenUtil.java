
package com.ejemplo.SpringBoot.Jwt;

import com.ejemplo.SpringBoot.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    //Declaramos una constante para manejar la excepción en caso que expire el token
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);    
    //Constante para definir el tiempo de caducidad del token (24hs)
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hs
    //Clave secreta que se usará para firmar digitalmente el token
    @Value("${app.jwt.secret}")
    private String secretKey;    
    //Creamos el método para generar el token, setear todo sus componentes(Sujeto,quien lo hace, fecha de creación, tiempo de expiración, algoritmo usado)
    public String generateAccessToken( Usuario user){
        return Jwts.builder()
                .setSubject(user.getId() + "," + user.getEmail())
                .setIssuer("Max")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512 , secretKey)
                .compact();
    }
    
    //Método para validar le JWT 
    public boolean validateAccessToken(String token){
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);            
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex);
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT is null, empty or has only whitespace", ex);
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex){
            LOGGER.error("Signature validation failed", ex);
        }
        return false;
    }
    
    //Método para obtener el dominio o sujeto del token
     public String getSubject(String token){
         return parseClaims(token).getSubject();
     }     
     private Claims parseClaims(String token){
         return Jwts.parser()
                 .setSigningKey(secretKey)
                 .parseClaimsJws(token)
                 .getBody();
     }
     
}
