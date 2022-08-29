package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Tecnologia;
import java.util.List;

public interface ITecnologiaService {
    public List<Tecnologia> verTecnologia();
    public void crearTecnologia(Tecnologia tech);
    public void borrarTecnologia(Long id);
    public Tecnologia buscarTecnologia(Long id);
    public void modificarTecnologia(Tecnologia tech );    
}
