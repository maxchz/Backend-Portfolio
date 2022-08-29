package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto tecnología
@Repository
public interface TecnologiaRepository extends JpaRepository <Tecnologia, Long> {
    
}
