package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> verHabilidad();
    public void crearHabilidad(Habilidad habil);
    public void borrarHabilidad(Long id);
    public Habilidad buscarHabilidad(Long id);
    public List<Habilidad> buscarHabilidadPorIdPersona(Long id);
    public void modificarHabilidad(Habilidad habil);    
}
