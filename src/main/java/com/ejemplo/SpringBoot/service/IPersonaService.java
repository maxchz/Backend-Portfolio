
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona(Persona pers);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public Persona buscarPersonaPorIdUsuario (Long id);
    public void modificarPersona(Persona pers);
}
