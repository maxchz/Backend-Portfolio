
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto experiencia
@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long>{
    //Creo un metodo para traer datos de la tabla experiencia segun el campo persona_id
    @Query("select x from Experiencia x where x.persona_id like :var_param")
    public abstract List<Experiencia> buscaPorIdPersona(@Param("var_param") Long id);
    
    
    
}
