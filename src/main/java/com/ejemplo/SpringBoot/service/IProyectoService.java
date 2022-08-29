package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> verProyecto();
    public void crearProyecto(Proyecto proy);    
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);    
    public List<Proyecto> buscarProyectoPorIdPersona(Long id);    
    public void modificarProyecto(Proyecto proy);    
}
