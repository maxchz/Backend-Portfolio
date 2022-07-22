
package com.ejemplo.SpringBoot.repository;


import com.ejemplo.SpringBoot.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto persona
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    //Definimos el metodo para buscar por campo usuario/email
    Optional<Usuario> findByEmail(String email);
    //public Usuario buscarPorUsuario (String usuario);
    
}
