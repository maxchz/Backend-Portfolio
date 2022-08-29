package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.HabilidadBlanda;
import java.util.List;

public interface IHabilidadBlandaService {
    public List<HabilidadBlanda> verHabilidadBlanda();
    public List<HabilidadBlanda> buscarHabBlandaPorHabBlanda(String habBlanda);
    public void crearHabilidadBlanda(HabilidadBlanda habBlan);
    public void borrarHabilidadBlanda(Long id);
    public HabilidadBlanda buscarHabilidadBlanda(Long id);
    public List<HabilidadBlanda> buscarHabBlandaPorIdPersona (Long id);
    public void modificarHabilidadBlanda(HabilidadBlanda habBlan);    
}
