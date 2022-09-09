package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.HabilidadBlanda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto habilidad Blanda
@Repository
public interface HabilidadBlandaRepository extends JpaRepository <HabilidadBlanda, Long> {
    //Creo una consulta para traer datos de la tabla habilidadBlanda según el campo persona_id
    @Query("select x from HabilidadBlanda x where x.persona_id like :var_param")
    public abstract List<HabilidadBlanda> buscarHabBlandaPorIdPersona(@Param("var_param") Long id);
    
    @Query("select x from HabilidadBlanda x where x.hab_blanda like :param")
    public List<HabilidadBlanda> buscarHabBlandaPorHabBlanda(@Param("param") String habBlanda);
}
