
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Tecnologia;
import com.ejemplo.SpringBoot.repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService {
    //Inyectamos la dependencia TecnologiaRepository
    @Autowired
    public TecnologiaRepository techRepo;
    //Implementa todos los metodos de la interface ITecnologiaService

    @Override
    public List<Tecnologia> verTecnologia() {
        return techRepo.findAll();
    }

    @Override
    public void crearTecnologia(Tecnologia tech) {
        techRepo.save(tech);
    }

    @Override
    public void borrarTecnologia(Long id) {
        techRepo.deleteById(id);
    }

    @Override
    public Tecnologia buscarTecnologia(Long id) {
        return techRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarTecnologia(Tecnologia tech) { 
        techRepo.save(tech);
    }
    
}
