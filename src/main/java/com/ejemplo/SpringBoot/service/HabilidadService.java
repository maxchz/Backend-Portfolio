
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.HabTech;
import com.ejemplo.SpringBoot.model.Habilidad;
import com.ejemplo.SpringBoot.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {
     //Inyectamos la dependencia HabilidadRepository
    @Autowired
    public HabilidadRepository habilRepo;
    //Implementa todos los metodos de la interface IPersonaService

    @Override
    public List<Habilidad> verHabilidad() {
        return habilRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad habil) {
        habilRepo.save(habil);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habilRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habilRepo.findById(id).orElse(null);
    }
    
    //Método para buscar habilidad por clave foránea id persona
    @Override
    public List<HabTech> buscarHabilidadPorIdPersona(Long id) {
        return habilRepo.buscaHabilidadPorIdPersona(id);
    }

    @Override
    public void modificarHabilidad(Habilidad habil) {
        habilRepo.save(habil);
    }
    
}


       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
