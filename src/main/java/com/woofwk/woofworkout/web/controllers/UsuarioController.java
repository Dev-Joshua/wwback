package com.woofwk.woofworkout.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.woofwk.woofworkout.domain.service.UsuarioService;
import com.woofwk.woofworkout.models.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllData() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellidos(usuarioDetails.getApellidos());
        usuario.setDocumento_identidad(usuarioDetails.getDocumento_identidad());
        usuario.setDireccion(usuarioDetails.getDireccion());
        usuario.setCelular(usuarioDetails.getCelular());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setRol(usuarioDetails.getRol());

        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        boolean isDeleted = usuarioService.deleteUsuario(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}