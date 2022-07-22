
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.HabilidadBlanda;
import com.ejemplo.SpringBoot.repository.HabilidadBlandaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadBlandaService implements IHabilidadBlandaService {
    //Inyectamos la dependencia HabilidadBlandaRepository
    @Autowired
    public HabilidadBlandaRepository habBlanRepo;
    //Implementa todos los metodos de la interface IHabilidadBlandaService

    @Override
    public List<HabilidadBlanda> verHabilidadBlanda() {
       return habBlanRepo.findAll();
        
    }

    @Override
    public void crearHabilidadBlanda(HabilidadBlanda habBlan) {
        habBlanRepo.save(habBlan);
    }

    @Override
    public void borrarHabilidadBlanda(Long id) {
        habBlanRepo.deleteById(id);
    }

    @Override
    public HabilidadBlanda buscarHabilidadBlanda(Long id) {
        return habBlanRepo.findById(id).orElse(null);
    }
    
    //Método para buscar Habilidad Blanda según clave foránea
    @Override
    public List<HabilidadBlanda> buscarHabBlandaPorIdPersona(Long id) {
        return habBlanRepo.buscarHabBlandaPorIdPersona(id);
    }

    @Override
    public void modificarHabilidadBlanda(HabilidadBlanda habBlan) {
        habBlanRepo.save(habBlan);
    }
    
}
