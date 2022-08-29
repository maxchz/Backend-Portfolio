package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    public void crearExperiencia(Experiencia expe);
    public void borrarExperienciaPorId(Long id);
    public Experiencia buscarExperiencia(Long id);
    public void modificarExperiencia(Experiencia expe);
    public List <Experiencia> buscarPorUsuarioId(Long id);    
}
