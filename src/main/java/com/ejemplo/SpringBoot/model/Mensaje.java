
package com.ejemplo.SpringBoot.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje {
   
    private String name;
    private String email;
    private String subject;
    private String body;
    
    public Mensaje(){}

    public Mensaje(String name, String email, String subject, String body) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.body = body;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail(){
        return email;
    }
    public void setMail(String email) {
        this.email = email;
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject) {
        this.subject= subject;
    }
    public String getBody(){
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
