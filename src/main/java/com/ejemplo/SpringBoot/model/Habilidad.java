
package com.ejemplo.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Modelo del objeto Habilidad
@Getter @Setter
@Entity
public class Habilidad {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private float progreso;
    private String urlTecLogo;
    private Long tecnologia_id;
    private Long persona_id;
    
    public Habilidad (){
        
    }

    
    public Habilidad(Long id,
                     float progreso,
                     String urlTecLogo,
                     Long tecnologia_id,
                     Long persona_id) {
        
        this.id = id;
        this.progreso = progreso;
        this.urlTecLogo = urlTecLogo;
        this.tecnologia_id = tecnologia_id;
        this.persona_id = persona_id;
    }
    
    
    
    
}
