package com.woofwk.woofworkout.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.UsuarioRepository;
import com.woofwk.woofworkout.models.Usuario;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    //Read
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    //Create
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Update
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setApellidos(usuarioDetails.getApellidos());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setContrasena(usuarioDetails.getContrasena());
            usuario.setDireccion(usuarioDetails.getDireccion());
            usuario.setDocumento_identidad(usuarioDetails.getDocumento_identidad());
            usuario.setCelular(usuarioDetails.getCelular());
            usuario.setRol(usuarioDetails.getRol());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    //Delete
    public boolean deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
            return true;
        }
        return false;
    }
}
