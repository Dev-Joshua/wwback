package com.woofwk.woofworkout.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.UsuarioRepository;
import com.woofwk.woofworkout.models.Usuario;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;
    
    //Read
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public Usuario getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //Create
    public Usuario saveUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    //Update
    public Usuario updateUser(Long id, Usuario usuarioDetails) {
        Usuario usuario = userRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setApellidos(usuarioDetails.getApellidos());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setContrasena(usuarioDetails.getContrasena());
            usuario.setDireccion(usuarioDetails.getDireccion());
            usuario.setDocumento_identidad(usuarioDetails.getDocumento_identidad());
            usuario.setCelular(usuarioDetails.getCelular());
            usuario.setRol(usuarioDetails.getRol());
            return userRepository.save(usuario);
        }
        return null;
    }

    //Delete
    public boolean deleteUser(Long id) {
        Usuario usuario = userRepository.findById(id).orElse(null);
        if (usuario != null) {
            userRepository.delete(usuario);
            return true;
        }
        return false;
    }
}
