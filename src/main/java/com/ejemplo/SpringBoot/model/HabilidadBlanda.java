
package com.ejemplo.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


//Modelo del objeto habilidadBlanda
@Getter @Setter
@Entity
public class HabilidadBlanda {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String habilidadBlanda;
    private Long persona_id;
    
    public HabilidadBlanda(){
        
    }

    public HabilidadBlanda(Long id, String habilidadBlanda, Long persona_id) {
        this.id = id;
        this.habilidadBlanda = habilidadBlanda;
        this.persona_id = persona_id;
    }
    
    
    
}
