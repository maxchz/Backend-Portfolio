package com.ejemplo.SpringBoot.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


//Modelo del objeto persona
@Getter @Setter
@Entity
//@Table
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    //@NotEmpty( message = "El campo nombre no debe estar vacio")
    //@Size (min=4, max=255, message= "El campo nombre debe tener entre 4 y 255 caracteres")
    private String nombre;
    //@NotEmpty( message = "El campo apellido no debe estar vacio")
    //@Size (min=4, max=255, message= "El campo apellido debe tener entre 4 y 255 caracteres")
    private String apellido;
    private String domicilio;
    private String fechaNac;
    //@Size (min=6, message= "El campo teléfono debe tener un mínimo de 6 caracteres")
    private String telefono;
    private String correo;
    //@Size (max=800, message= "El campo sobre mí debe tener un máximo de 800 caracteres")
    private String sobreMi;
    private String posicionDev;
    private String imagenPerfil;
    private Long usuario_id;
    
   
    //@OneToMany(fetch=FetchType.LAZY, mappedBy= "persona")
    //private List<Experiencia> experiencia;
            
    
    public Persona(){
        
    }

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
        //this.experiencia = experiencia;
        
    }
    
    
    
}
