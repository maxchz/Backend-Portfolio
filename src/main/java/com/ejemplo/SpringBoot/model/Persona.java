package com.ejemplo.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Modelo del objeto persona
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    private String nombre;   
    private String apellido;
    private String domicilio;
    private String fechaNac;
    private String telefono;
    private String correo;
    private String sobreMi;
    private String posicionDev;
    private String imagenPerfil;
    private Long usuario_id;
        
    public Persona(){}

    public Persona(Long id,
                   String nombre,
                   String apellido,
                   String domicilio,
                   String fechaNac,
                   String telefono,
                   String correo,
                   String sobreMi,
                   String posicionDev,
                   String imagenPerfil,
                   Long usuario_id
                   )  {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNac = telefono;
        this.correo = correo;
        this.sobreMi = sobreMi;
        this.posicionDev = posicionDev;
        this.imagenPerfil = imagenPerfil;
        this.usuario_id = usuario_id;        
    }    
}
