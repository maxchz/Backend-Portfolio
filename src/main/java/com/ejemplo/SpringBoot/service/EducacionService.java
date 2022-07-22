
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducacionService implements IEducacionService {
      //Inyectamos la dependencia EducacionRepository
    @Autowired
    public EducacionRepository educaRepo;
    //Implementa todos los metodos de la interface IPersonaService

    @Override
    public List<Educacion> verEducacion() {
        return educaRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion educa) {
        educaRepo.save(educa);
    }

    @Override
    public void borrarEducacion(Long id) {
        educaRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return educaRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Educacion> buscarEducacionPorIdPersona(Long id){
        return educaRepo.buscaEducacionPorIdPersona(id);
    }

    @Override
    public void modificarEducacion(Educacion educa) {
        educaRepo.save(educa);
    }
    
}
