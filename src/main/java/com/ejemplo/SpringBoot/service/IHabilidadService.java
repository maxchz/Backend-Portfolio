
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.HabTech;
import com.ejemplo.SpringBoot.model.Habilidad;
import java.util.List;


public interface IHabilidadService {
        //Metodos del CRUD: GET
    public List<Habilidad> verHabilidad();

    //Metodos del CRUD: POST
    public void crearHabilidad(Habilidad habil);
    
    //Metodos del CRUD: DELETE
    public void borrarHabilidad(Long id);

    //Metodos del CRUD: 
    public Habilidad buscarHabilidad(Long id);
    
    //Método para buscar Habilidad segun clave foránea
    public List<HabTech> buscarHabilidadPorIdPersona(Long id);
    
    //MEtodo del CRUD: modificar
    public void modificarHabilidad(Habilidad habil);
    
}
