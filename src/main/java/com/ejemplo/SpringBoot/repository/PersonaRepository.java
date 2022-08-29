package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto persona
@Repository
public interface PersonaRepository extends JpaRepository <Persona,  Long> {
    //Creo una consulta para traer datos de la tabla Persona según el campo usuario_id
    @Query("select x from Persona x where x.usuario_id like :var_param")
    public abstract Persona buscaPersonaPorIdUsuario(@Param("var_param") Long usuario_id);    
}


