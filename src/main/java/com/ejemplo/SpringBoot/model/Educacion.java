
package com.ejemplo.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String institucion;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String url_logo;
    private Long persona_id;
    
    public Educacion(){
    }

    public Educacion(Long id,
                     String institucion,
                     String titulo,
                     String descripcion,
                     String fechaInicio,
                     String fechaFin,
                     String url_logo,
                     Long persona_id) {
        
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.url_logo = url_logo;
        this.persona_id = persona_id;
    }
    
    
    
}
