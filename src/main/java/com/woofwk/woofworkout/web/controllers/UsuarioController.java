package com.woofwk.woofworkout.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.woofwk.woofworkout.domain.dto.UsuarioDto;
import com.woofwk.woofworkout.domain.repository.UsuarioRepository;
import com.woofwk.woofworkout.domain.service.MascotaService;
import com.woofwk.woofworkout.domain.service.UsuarioService;
import com.woofwk.woofworkout.models.Mascota;
import com.woofwk.woofworkout.models.Usuario;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    // @Autowired
    // private UsuarioRepository userRepository;


    // @Autowired
    // private MascotaService petServicce;


    // Metodos para realizar un CRUD


    // Metodo para obtener los usuarios de la base de datos
    @GetMapping({"", "/"})
    public String mostrarUsuarios(Model model) {
        List<Usuario> usuarios = userService.getAllUsers();
        usuarios.sort(Comparator.comparing(Usuario::getId_usuario).reversed());
        model.addAttribute("usuarios", usuarios);

        return "usuarios/index";
    }
    


    // Metodo para mostrar el formulario de creacion
    @GetMapping("/crear")
    public String crearFormulario(Model model) {
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto", usuarioDto);
        return "usuarios/createUser";
    }
    

  

    // Metodo para crear un usuario mediante un POST desde la url indicada
     @PostMapping("/crear")
     public String crearUsuario(@ModelAttribute("usuarioDto") UsuarioDto usuarioDto, RedirectAttributes redirectAttributes) {
        Usuario usuario = new Usuario();
        
        // Copio los datos del DTO a la entidad Usuario
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setDocumento_identidad(usuarioDto.getDocumento_identidad());
        usuario.setDireccion(usuarioDto.getDireccion());
        usuario.setCelular(usuarioDto.getCelular());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setContrasena(usuarioDto.getContrasena());
        usuario.setRol(usuarioDto.getRol());

        // Registrar el nuevo usuario en la bd
        userService.createUser(usuario); 
        redirectAttributes.addFlashAttribute("message", "Usuario creado con éxito");

        return "redirect:/usuarios";
    }

    
   

    
    // Metodo para crear un usuario mediante un POST desde la url indicada
    @GetMapping("/editar")
    public String mostrarPaginaEdit(Model model, @RequestParam int id) {
        
        Usuario usuario = userService.getUserById(id);
        if (usuario == null) {
            throw new IllegalArgumentException("Invalid user Id:" + id);
        }
        
        UsuarioDto usuarioDto = new UsuarioDto();
        // usuarioDto.setId_usuario(usuarioDto.getId_usuario());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellidos(usuario.getApellidos());
        usuarioDto.setDocumento_identidad(usuario.getDocumento_identidad());
        usuarioDto.setDireccion(usuario.getDireccion());
        usuarioDto.setCelular(usuario.getCelular());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setContrasena(usuario.getContrasena());
        usuarioDto.setRol(usuario.getRol());
        
        model.addAttribute("usuarioDto", usuarioDto);
        
        return "usuarios/editUser";
        
    }
    
    @PostMapping("editar")
    public String actualiarUsuario(Model model, @RequestParam int id, @ModelAttribute("usuarioDto") UsuarioDto usuarioDto, RedirectAttributes redirectAttributes) {
        
        Usuario usuario = userService.getUserById(id);
        
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setDocumento_identidad(usuarioDto.getDocumento_identidad());
        usuario.setDireccion(usuarioDto.getDireccion());
        usuario.setCelular(usuarioDto.getCelular());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setContrasena(usuarioDto.getContrasena());
        usuario.setRol(usuarioDto.getRol());
        
        
        userService.updateUser(id, usuario); 
        redirectAttributes.addFlashAttribute("message", "Usuario actualizado con éxito");
        
        return "redirect:/usuarios";
    }
    
    
    @GetMapping("/eliminar")
    public String eliminarUsuario(@RequestParam int id, RedirectAttributes redirectAttributes) {
        
        Usuario usuario = userService.getUserById(id);
        if (usuario == null) {
            throw new IllegalArgumentException("Invalid user Id:" + id);
        };
        
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "Usuario eliminado con éxito");
        
        return "redirect:/usuarios";
        
    }

    //Metodos para API REST

    // @GetMapping
    // public List<Usuario> getAllData() {
    //     return userService.getAllUsers();
    // }
    
    // @GetMapping("/{id}")
    // public Usuario getUseroById(@PathVariable Integer id) {
    //     return userService.getUserById(id);
    // }


    // @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    //  public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
    //     Usuario nuevoUsuario = userService.createUser(usuario);
    //     return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    // }


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