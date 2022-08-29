package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    //Inyectamos la dependencia ExperienciaRepository
    @Autowired
    public ExperienciaRepository experienciaRepo;    
    @Override
    public List<Experiencia> verExperiencia() {
        return experienciaRepo.findAll();        
    }
    @Override
    public void crearExperiencia(Experiencia expe) {
        experienciaRepo.save(expe);
    }
    @Override
    public void borrarExperienciaPorId(Long id) {
        experienciaRepo.deleteById(id);
    }
    @Override
    public Experiencia buscarExperiencia(Long id) {
        return experienciaRepo.findById(id).orElse(null);
    }
    @Override
    public void modificarExperiencia(Experiencia expe) {
        experienciaRepo.save(expe);
    }    
    @Override
    public List<Experiencia> buscarPorUsuarioId(Long id){
      return experienciaRepo.buscaPorIdPersona(id);
    }
}
