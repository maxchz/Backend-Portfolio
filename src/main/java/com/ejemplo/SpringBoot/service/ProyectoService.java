package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    //Inyectamos la dependencia ProyectoRepository
    @Autowired
    public ProyectoRepository proyectRepo;
    //Implementa todos los métodos de la interface IPersonaService
    @Override
    public List<Proyecto> verProyecto() {
        return proyectRepo.findAll();
    }
    @Override
    public void crearProyecto(Proyecto proy) {
        proyectRepo.save(proy);        
    }
    @Override
    public void borrarProyecto(Long id) {
        proyectRepo.deleteById(id);
    }
    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyectRepo.findById(id).orElse(null);
    }    
    @Override
    public List<Proyecto> buscarProyectoPorIdPersona(Long id){
        return proyectRepo.buscaEducacionPorIdPersona(id);
    }
    @Override
    public void modificarProyecto(Proyecto proy) {
        proyectRepo.save(proy);
    }    
}
