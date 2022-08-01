
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    //Metodos del CRUD: GET
    public List<Persona> verPersonas();

    //Metodos del CRUD: POST
    public void crearPersona(Persona pers);
    
    //Metodos del CRUD: DELETE
    public void borrarPersona(Long id);

    //Metodos del CRUD: 
    public Persona buscarPersona(Long id);
    
    public Persona buscarPersonaPorIdUsuario (Long id);
    
    //MEtodo del CRUD: modificar
    
    public void modificarPersona(Persona pers);


    
    
}
