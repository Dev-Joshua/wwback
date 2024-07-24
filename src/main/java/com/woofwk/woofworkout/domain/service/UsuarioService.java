package com.woofwk.woofworkout.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.ServicioRepository;
import com.woofwk.woofworkout.domain.repository.UsuarioRepository;
import com.woofwk.woofworkout.models.Servicio;
import com.woofwk.woofworkout.models.Usuario;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private ServicioRepository servicioRepository;
    
    //Read
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public Usuario getUserById(Integer usuarioId) {
        return userRepository.findById(usuarioId).orElse(null);
    }

    public Usuario createUser(Usuario user) {
        Usuario savedUsuario = userRepository.save(user);

        return savedUsuario;
    }

    // //Create
    // public Usuario saveUser(Usuario usuario) {
    //     return userRepository.save(usuario);
    // }

    //Update
    public Usuario updateUser(Integer id, Usuario usuarioDetails) {
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
    public boolean deleteUser(Integer id) {
        Usuario usuario = userRepository.findById(id).orElse(null);
        if (usuario != null) {
            userRepository.delete(usuario);
            return true;
        }
        return false;
    }
}
