package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto proyecto
@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {
    //Creo una consulta para traer datos de la tabla educación según el campo persona_id
    @Query("select x from Proyecto x where x.persona_id like :var_param")
    public abstract List<Proyecto> buscaEducacionPorIdPersona(@Param("var_param") Long id);    
}
