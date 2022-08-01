
package com.ejemplo.SpringBoot.repository;


import com.ejemplo.SpringBoot.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Repositorio para el objeto persona
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    //Definimos el método para buscar si existe el usuario por campo email, para el ApplicationSecurityConfig
    Optional<Usuario> findByEmail(String email);
    //public Usuario buscarPorUsuario (String usuario);
    
    //Creo un método para traer datos de la tabla Usuario segun el campo email
    @Query("select x from Usuario x where x.email like :var_param")
    public abstract Usuario buscaUsuarioPorEmail(@Param("var_param") String email);
    
}
