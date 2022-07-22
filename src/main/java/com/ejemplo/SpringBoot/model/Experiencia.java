package com.ejemplo.SpringBoot.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//Modelo del objeto experiencia
@Getter @Setter
@Entity
public class Experiencia {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    //@NotEmpty( message = "El campo nombre empresa no debe estar vacio")
    private String nombreEmpresa;
    private String posicion;
    private String fechaInicio;
    private String fechaFin;
    //@Size (max=800, message= "El campo descripción debe tener un máximo de 800 caracteres")
    private String descripcion;
    
    private Long persona_id;
    
       
    //@ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    //private Persona persona;
    //@JoinColumn(name = "id", updatable = false, insertable = false)
    //private Persona persona;
    
    
    public Experiencia (){
    }

    public Experiencia(Long id,
                       String nombreEmpresa,
                       String posicion,
                       String fechaInicio,
                       String fechaFin,
                       String descripcion,
                       Long persona_id) {
        
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.posicion = posicion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        //this.persona = persona;
        this.persona_id = persona_id;
    }
    
    
}
