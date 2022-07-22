
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto educacion
@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long> {
    //Creo un metodo para traer datos de la tabla educación segun el campo persona_id
    @Query("select x from Educacion x where x.persona_id like :var_param")
    public abstract List<Educacion> buscaEducacionPorIdPersona(@Param("var_param") Long id);
}
