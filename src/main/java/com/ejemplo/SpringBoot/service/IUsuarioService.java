
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;
import java.util.List;

public interface IUsuarioService {
     //Metodos del CRUD: GET
    public List<Usuario> verUsuario();

    //Metodos del CRUD: POST
    public void crearUsuario(Usuario user);
    
    //Metodos del CRUD: DELETE
    public void borrarUsuario(Long id);

    //Metodos del CRUD: 
    public Usuario buscarUsuario(Long id);
    
    public Usuario buscarUsuarioPorEmail(String email);
    
    public boolean existeEmailRegistro(String email);
    
    //MEtodo del CRUD: modificar
    
    public void modificarUsuario(Usuario user);
    
}
