package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> verUsuario();
    public void crearUsuario(Usuario user);
    public void borrarUsuario(Long id);
    public Usuario buscarUsuario(Long id);
    public Usuario buscarUsuarioPorEmail(String email);
    public boolean existeEmailRegistro(String email);
    public void modificarUsuario(Usuario user);
}
