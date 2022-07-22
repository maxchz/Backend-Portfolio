
package com.ejemplo.SpringBoot.model;

//Modelo del obhjeto proyecto

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String urlProyecto;
    private String urlRepositorio;
    private Long persona_id;
    
    public Proyecto(){
    }

    public Proyecto(Long id,
                    String nombre,
                    String descripcion,
                    String fechaInicio,
                    String fechaFin,
                    String urlProyecto,
                    String urlRepositorio,
                    Long persona_id) {
        
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlProyecto = urlProyecto;
        this.urlRepositorio = urlRepositorio;
        this.persona_id = persona_id;
    }
    
    
    
}
