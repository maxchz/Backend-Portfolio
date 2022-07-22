
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyecto;
import java.util.List;


public interface IProyectoService {
     //Metodos del CRUD: GET
    public List<Proyecto> verProyecto();

    //Metodos del CRUD: POST
    public void crearProyecto(Proyecto proy);
    
    //Metodos del CRUD: DELETE
    public void borrarProyecto(Long id);

    //Metodos del CRUD: 
    public Proyecto buscarProyecto(Long id);
    
    //Método para buscar proyecto por clave foránea
    public List<Proyecto> buscarProyectoPorIdPersona(Long id);
    
    //Método del CRUD: modificar  
    public void modificarProyecto(Proyecto proy);

    
}
