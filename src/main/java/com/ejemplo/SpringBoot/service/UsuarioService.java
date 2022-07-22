
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;
import com.ejemplo.SpringBoot.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements IUsuarioService {
    //Inyectamos la dependencia UsuarioRepository
    @Autowired
    public UsuarioRepository userRepo;
    
    //Inyectamos la dependencia UserRepository
    //@Autowired
    //public UsuarioRepository

    
    
    
    
    //Implementa todos los metodos de la interface IPersonaService    
    @Override
    public List<Usuario> verUsuario() {
        return userRepo.findAll();
    }

    @Override
    public void crearUsuario(Usuario user) {
        userRepo.save(user);
    }

    @Override
    public void borrarUsuario(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarUsuario(Usuario user) {
        userRepo.save(user);
    }

    //@Override
    //@Transactional(readOnly = true)
    //public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    return (UserDetails) userRepo.buscarPorUsuario(username);
    //}
    
}
