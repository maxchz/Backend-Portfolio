
package com.ejemplo.SpringBoot.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Modelo del objeto tecnología
@Getter @Setter
@Entity
public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String tecnologia;
    
    public Tecnologia(){
        
    }

    public Tecnologia(Long id, String tecnologia) {
        this.id = id;
        this.tecnologia = tecnologia;
    }
    
    
    
}
