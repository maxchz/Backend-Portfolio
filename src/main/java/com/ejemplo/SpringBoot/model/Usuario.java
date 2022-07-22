package com.ejemplo.SpringBoot.model;


import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Modelo del objeto email
@Getter @Setter
@Entity
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    //private Long persona_id;

    
    public Usuario (){
        
    }
    /*public Usuario(Long id, String email, String password, Long persona_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        //this.persona_id = persona_id;
    }*/
    
    public Usuario (String email, String password){
        this.email = email;
        this.password = password;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
     public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
   
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /*@Override
    public String getPassword() {
        return null;
    }*/

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

  
    
    
    
    
    
}
