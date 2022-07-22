
package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Modelo del objeto Habilidad mas Tecnologia
//@Getter @Setter
//@Entity
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HabTech {
   
    private Long id;
    private float progreso;
    private String urlTecLogo;
    private String tecnologia;
    
    public HabTech (){
        
    }

    public HabTech(Long id, float progreso, String urlTecLogo, String tecnologia) {
        this.id = id;
        this.progreso = progreso;
        this.urlTecLogo = urlTecLogo;
        this.tecnologia = tecnologia;
    }

    
    
    
    
    
}
