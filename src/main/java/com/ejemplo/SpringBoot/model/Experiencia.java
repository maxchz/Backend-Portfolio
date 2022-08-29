package com.ejemplo.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Modelo del objeto experiencia
@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombreEmpresa;
    private String posicion;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;    
    private Long persona_id;
    
    public Experiencia (){}

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
        this.persona_id = persona_id;
    }    
}
