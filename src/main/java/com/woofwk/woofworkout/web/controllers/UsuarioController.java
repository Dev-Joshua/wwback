package com.woofwk.woofworkout.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.woofwk.woofworkout.domain.service.MascotaService;
import com.woofwk.woofworkout.domain.service.UsuarioService;
import com.woofwk.woofworkout.models.Mascota;
import com.woofwk.woofworkout.models.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private MascotaService petServicce;


    // Metodos
    @GetMapping
    public List<Usuario> getAllData() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUseroById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Usuario createUs(@RequestBody Usuario usuario) {
        return userService.saveUser(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
       Usuario usuario = userService.getUserById(id);
       if (usuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
    }

        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellidos(usuarioDetails.getApellidos());
        usuario.setDocumento_identidad(usuarioDetails.getDocumento_identidad());
        usuario.setDireccion(usuarioDetails.getDireccion());
        usuario.setCelular(usuarioDetails.getCelular());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setContrasena(usuarioDetails.getContrasena());
        usuario.setRol(usuarioDetails.getRol());

        userService.saveUser(usuario);

        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = userService.getUserById(id);
        if (usuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
        }

    @GetMapping("/{id}/mascotas")
    public ResponseEntity<List<Mascota>> obtenerMascotasPorUsuario(@PathVariable Long id) {
        Usuario usuario = userService.getUserById(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(usuario.getMascotas());
    }

    @PostMapping("/{id}/mascotas")
    public ResponseEntity<Mascota> crearMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Usuario usuario = userService.getUserById(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        mascota.setUsuario(usuario);
        Mascota nuevaMascota = petServicce.createPet(mascota);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }


}