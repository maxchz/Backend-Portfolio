
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto persona
@Repository
public interface PersonaRepository extends JpaRepository <Persona,  Long> {
    
}


