
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.HabilidadBlanda;
import java.util.List;


public interface IHabilidadBlandaService {
    //Metodos del CRUD: GET
    public List<HabilidadBlanda> verHabilidadBlanda();

    //Metodos del CRUD: POST
    public void crearHabilidadBlanda(HabilidadBlanda habBlan);
    
    //Metodos del CRUD: DELETE
    public void borrarHabilidadBlanda(Long id);

    //Metodos del CRUD: 
    public HabilidadBlanda buscarHabilidadBlanda(Long id);
    
    //Método para buscar Habilidad Blanda según clave foránea
    public List<HabilidadBlanda> buscarHabBlandaPorIdPersona (Long id);
    
    //Método del CRUD: modificar
    public void modificarHabilidadBlanda(HabilidadBlanda habBlan);
    
}
