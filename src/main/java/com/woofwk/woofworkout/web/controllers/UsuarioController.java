package com.woofwk.woofworkout.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.woofwk.woofworkout.domain.dto.UsuarioDto;
import com.woofwk.woofworkout.domain.repository.UsuarioRepository;
import com.woofwk.woofworkout.domain.service.MascotaService;
import com.woofwk.woofworkout.domain.service.UsuarioService;
import com.woofwk.woofworkout.models.Mascota;
import com.woofwk.woofworkout.models.Usuario;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    // @Autowired
    // private UsuarioRepository userRepository;

    @Autowired
    private UsuarioService userService;

    // @Autowired
    // private MascotaService petServicce;


    // Metodos

    // @GetMapping
    // public List<Usuario> getAllData() {
    //     return userService.getAllUsers();
    // }

    @GetMapping({"", "/"})
    public String mostrarProductos(Model model) {
        List<Usuario> usuarios = userService.getAllUsers();
        model.addAttribute("usuarios", usuarios);

        return "usuarios/index";
    }
    

    // @GetMapping("/{id}")
    // public Usuario getUseroById(@PathVariable Integer id) {
    //     return userService.getUserById(id);
    // }
    

    // @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    //  public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
    //     Usuario nuevoUsuario = userService.createUser(usuario);
    //     return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    // }

    //  @PostMapping("/create")
    //  public String crearUsuario(@ModelAttribute("usuarioDto") UsuarioDto usuarioDto) {
    //     Usuario usuario = new Usuario();
        
    //     // Copio los datos del DTO a la entidad Usuario
    //     usuario.setNombre(usuarioDto.getNombre());
    //     usuario.setApellidos(usuarioDto.getApellidos());
    //     usuario.setDocumento_identidad(usuarioDto.getDocumento_identidad());
    //     usuario.setDireccion(usuarioDto.getDireccion());
    //     usuario.setCelular(usuarioDto.getCelular());
    //     usuario.setEmail(usuarioDto.getEmail());
    //     usuario.setContrasena(usuarioDto.getContrasena());
    //     // usuario.setRol(usuarioDto.getRol());

    //     userService.createUser(usuario); // Guarda el usuario en la base de datos

    //     return "redirect:/usuarios";
    // }

    
    @GetMapping("/crear")
    public String formCreate(Model model) {
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto", usuarioDto);
        return "usuarios/createUser";
    }


    // @PutMapping("/{id}")
    // public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody Usuario usuarioDetails) {
    //    Usuario usuario = userService.getUserById(id);
    //    if (usuario == null) {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
    // }

    //     usuario.setNombre(usuarioDetails.getNombre());
    //     usuario.setApellidos(usuarioDetails.getApellidos());
    //     usuario.setDocumento_identidad(usuarioDetails.getDocumento_identidad());
    //     usuario.setDireccion(usuarioDetails.getDireccion());
    //     usuario.setCelular(usuarioDetails.getCelular());
    //     usuario.setEmail(usuarioDetails.getEmail());
    //     usuario.setContrasena(usuarioDetails.getContrasena());
    //     usuario.setRol(usuarioDetails.getRol());

    //     userService.createUser(usuario);

    //     return ResponseEntity.ok("Usuario actualizado exitosamente");
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
    //     Usuario usuario = userService.getUserById(id);
    //     if (usuario == null) {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
    //     }
    
    //     userService.deleteUser(id);
    //     return ResponseEntity.ok("Usuario eliminado exitosamente");
    //     }

    // @GetMapping("/{id}/mascotas")
    // public ResponseEntity<List<Mascota>> obtenerMascotasPorUsuario(@PathVariable Integer id) {
    //     Usuario usuario = userService.getUserById(id);
    //     if (usuario == null) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    //     }
    //     return ResponseEntity.ok(usuario.getMascotas());
    // }

    // @PostMapping("/{id}/mascotas")
    // public ResponseEntity<Mascota> crearMascota(@PathVariable Integer id, @RequestBody Mascota mascota) {
    //     Usuario usuario = userService.getUserById(id);
    //     if (usuario == null) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    //     }
    //     mascota.setUsuario(usuario);
    //     Mascota nuevaMascota = petServicce.createPet(mascota);

    //     return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    // }


}