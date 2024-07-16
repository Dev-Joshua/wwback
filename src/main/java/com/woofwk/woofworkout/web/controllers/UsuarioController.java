package com.woofwk.woofworkout.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    // @GetMapping("/{id}")
    // public Usuario getUsuarioById(@PathVariable Long id) {
    //     return usuarioService.getUsuarioById(id);
    // }

    // @PostMapping
    // public Usuario createUsuario(@RequestBody Usuario usuario) {
    //     return usuarioService.saveUsuario(usuario);
    // }

    // @PutMapping("/{id}")
    // public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
    //     Usuario usuario = usuarioService.getUsuarioById(id);

    //     usuario.setNombre(usuarioDetails.getNombre());
    //     usuario.setEmail(usuarioDetails.getEmail());

    //     // actualizar otros campos según sea necesario

    //     return usuarioService.saveUsuario(usuario);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteUsuario(@PathVariable Long id) {
    //     usuarioService.deleteUsuario(id);
    // }
}