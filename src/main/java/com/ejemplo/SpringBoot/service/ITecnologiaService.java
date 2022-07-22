
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Tecnologia;
import java.util.List;


public interface ITecnologiaService {
     //Metodos del CRUD: GET
    public List<Tecnologia> verTecnologia();

    //Metodos del CRUD: POST
    public void crearTecnologia(Tecnologia tech);
    
    //Metodos del CRUD: DELETE
    public void borrarTecnologia(Long id);

    //Metodos del CRUD: 
    public Tecnologia buscarTecnologia(Long id);
    
    //MEtodo del CRUD: modificar
    
    public void modificarTecnologia(Tecnologia tech );
    
}
