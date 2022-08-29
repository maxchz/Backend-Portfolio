
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //Metodos del CRUD: GET
    public List<Experiencia> verExperiencia();

    //Metodos del CRUD: POST
    public void crearExperiencia(Experiencia expe);
    
    //Metodos del CRUD: DELETE
    public void borrarExperienciaPorId(Long id);
    

    //Metodos del CRUD: 
    public Experiencia buscarExperiencia(Long id);
    
    //MEtodo del CRUD: modificar
    
    public void modificarExperiencia(Experiencia expe);
    
    //Metodo para traer datos segun id usuario (foreign key)
    public List <Experiencia> buscarPorUsuarioId(Long id);
    
}
