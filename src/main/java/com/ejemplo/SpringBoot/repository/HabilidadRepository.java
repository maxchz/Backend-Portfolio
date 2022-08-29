package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Habilidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto habilidad
@Repository
public interface HabilidadRepository extends JpaRepository <Habilidad, Long> {
    //Creo una consulta para traer datos de la tabla habilidad según el campo persona_id
    @Query("select x from Habilidad x where x.persona_id like :var_param")
    public abstract List<Habilidad> buscaHabilidadPorIdPersona(@Param("var_param") Long id);
}


