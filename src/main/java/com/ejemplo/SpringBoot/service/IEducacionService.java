
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;
import java.util.List;


public interface IEducacionService {
        //Metodos del CRUD: GET
    public List<Educacion> verEducacion();

    //Metodos del CRUD: POST
    public void crearEducacion(Educacion educa);
    
    //Metodos del CRUD: DELETE
    public void borrarEducacion(Long id);

    //Metodos del CRUD: 
    public Educacion buscarEducacion(Long id);
    
    
    //Metodo para buscar Educacion por clave foránea
    
    public List<Educacion> buscarEducacionPorIdPersona(Long id);
    
    //MEtodo del CRUD: modificar
    
    public void modificarEducacion (Educacion educa);

}
