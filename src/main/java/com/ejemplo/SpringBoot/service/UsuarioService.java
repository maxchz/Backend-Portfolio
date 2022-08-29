package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Usuario;
import com.ejemplo.SpringBoot.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    //Inyectamos la dependencia UsuarioRepository
    @Autowired
    public UsuarioRepository userRepo;    
    //Implementa todos los métodos de la interface IPersonaService    
    @Override
    public List<Usuario> verUsuario() {
        return userRepo.findAll();
    }
    @Override
    public void crearUsuario(Usuario user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());        
        Usuario newUser = new Usuario (user.getEmail(), encodedPassword);
        userRepo.save(newUser);           
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
    public Usuario buscarUsuarioPorEmail(String email) {
        return userRepo.buscaUsuarioPorEmail(email);
    }    
    @Override
    public boolean existeEmailRegistro(String email) {
        return userRepo.existeEmailRegistro(email);
    }
    @Override
    public void modificarUsuario(Usuario user) {
        userRepo.save(user);
    }
    
}
