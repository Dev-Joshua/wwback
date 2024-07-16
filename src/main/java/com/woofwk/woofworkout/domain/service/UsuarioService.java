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

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // public Usuario getUsuarioById(Long id) {
    //     return usuarioRepository.findById(id).orElse(null);
    // }

    // public Usuario saveUsuario(Usuario usuario) {
    //     return usuarioRepository.save(usuario);
    // }

    // public void deleteUsuario(Long id) {
    //     usuarioRepository.deleteById(id);
    // }
}
