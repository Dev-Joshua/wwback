package com.woofwk.woofworkout.web.controllers;

import java.util.Comparator;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.woofwk.woofworkout.domain.dto.MascotaDto;
import com.woofwk.woofworkout.domain.dto.UsuarioDto;
import com.woofwk.woofworkout.domain.service.MascotaService;
import com.woofwk.woofworkout.domain.service.UsuarioService;
import com.woofwk.woofworkout.models.Mascota;
import com.woofwk.woofworkout.models.Usuario;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService petService;

    @Autowired
    private UsuarioService useService;

    // Metodos CRUD

    // Metodo para obtener las mascotas de la base de datos
    @GetMapping({"", "/"})
    public String mostrarMasotas(Model model) {
        List<Mascota> mascotas = petService.getAllPets();
        mascotas.sort(Comparator.comparing(Mascota::getId_mascota).reversed());
        model.addAttribute("mascotas", mascotas);

        return "mascotas/index";
    }

    
    // Metodo para mostrar el formulario de creacion
    @GetMapping("/crear")
    public String crearFormulario(Model model) {
        MascotaDto mascotaDto = new MascotaDto();
        model.addAttribute("mascotaDto", mascotaDto);
        return "mascotas/createPet";
    }

    // Metodo para crear una mascota mediante un POST desde la url indicada
     @PostMapping("/crear")
     public String crearMascota(@ModelAttribute("mascotaDto") MascotaDto mascotaDto, RedirectAttributes redirectAttributes) {
        Mascota mascota = new Mascota();
        
        // Copio los datos del DTO a la entidad Mascota
        mascota.setTipo_mascota(mascotaDto.getTipo_mascota());
        mascota.setNombre(mascotaDto.getNombre());
        mascota.setEdad(mascotaDto.getEdad());
        mascota.setRaza(mascotaDto.getRaza());
        mascota.setPeso(mascotaDto.getPeso());
        mascota.setTamano(mascotaDto.getTamano());
        mascota.setSexo(mascotaDto.getSexo());
        mascota.setEsterilizado(mascotaDto.getEsterilizado());
        mascota.setDescripcion_mascota(mascotaDto.getDescripcion_mascota());
        mascota.setInfo_cuidado(mascotaDto.getInfo_cuidado());
        mascota.setFoto_mascota(mascotaDto.getFoto_mascota());
        // mascota.setMascota(mascotaDto.getMascota());

        // Asignar el usuario a la mascota
        Integer usuarioId = mascotaDto.getUsuario() != null ? mascotaDto.getUsuario().getId_usuario() : null;
        if (usuarioId != null) {
            Usuario usuario = useService.getUserById(usuarioId);
            mascota.setUsuario(usuario);
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/mascotas/crear";
        }

        // Registrar mascota en la bd
        petService.createPet(mascota); 
        redirectAttributes.addFlashAttribute("message", "Mascota creada con éxito");

        return "redirect:/mascotas";
    }


      // Metodo para crear una mascota mediante un POST desde la url indicada
     @GetMapping("/editar")
     public String mostrarPaginaEditMascota(Model model, @RequestParam int id) {

            Mascota mascota = petService.getPetById(id);
            if (mascota == null) {
                throw new IllegalArgumentException("Invalid pet Id:" + id);
            }

            MascotaDto mascotaDto = new MascotaDto();
            
            mascotaDto.setTipo_mascota(mascota.getTipo_mascota());
            mascotaDto.setNombre(mascota.getNombre());
            mascotaDto.setEdad(mascota.getEdad());
            mascotaDto.setRaza(mascota.getRaza());
            mascotaDto.setPeso(mascota.getPeso());
            mascotaDto.setTamano(mascota.getTamano());
            mascotaDto.setSexo(mascota.getSexo());
            mascotaDto.setEsterilizado(mascota.getEsterilizado());
            mascotaDto.setDescripcion_mascota(mascota.getDescripcion_mascota());
            mascotaDto.setInfo_cuidado(mascota.getInfo_cuidado());
            mascotaDto.setFoto_mascota(mascota.getFoto_mascota());
            // mascotaDto.setUsuario(mascota.getUsuario());

            model.addAttribute("mascotaDto", mascotaDto);
            

            return "mascotas/petEdit";
    
    }

     @PostMapping("editar")
     public String actualizarMascota(Model model, @RequestParam int id, @ModelAttribute("mascotaDto") MascotaDto mascotaDto, RedirectAttributes redirectAttributes) {
        
        Mascota mascota = petService.getPetById(id);
      
        mascota.setTipo_mascota(mascotaDto.getTipo_mascota());
        mascota.setNombre(mascotaDto.getNombre());
        mascota.setEdad(mascotaDto.getEdad());
        mascota.setRaza(mascotaDto.getRaza());
        mascota.setPeso(mascotaDto.getPeso());
        mascota.setTamano(mascotaDto.getTamano());
        mascota.setSexo(mascotaDto.getSexo());
        mascota.setEsterilizado(mascotaDto.getEsterilizado());
        mascota.setDescripcion_mascota(mascotaDto.getDescripcion_mascota());
        mascota.setInfo_cuidado(mascotaDto.getInfo_cuidado());
        mascota.setFoto_mascota(mascotaDto.getFoto_mascota());

        
        petService.updatePet(id, mascota); 
        redirectAttributes.addFlashAttribute("message", "Mascota actualizada con éxito");

        return "redirect:/mascotas";
    }

    
    @GetMapping("/eliminar")
    public String eliminarMascota(@RequestParam int id, RedirectAttributes redirectAttributes) {

       Mascota mascota = petService.getPetById(id);
        if (mascota == null) {
                throw new IllegalArgumentException("Invalid pet Id:" + id);
        };

        petService.deletePet(id);
        redirectAttributes.addFlashAttribute("message", "Mascota eliminada");

        return "redirect:/mascotas";

    }


    //Metodos para API REST

    // @GetMapping
    // public List<Mascota> getAllData() {
    //     return petService.getAllPets();
    // }

    // @GetMapping("/{id}")
    // public Mascota getMascotaById(@PathVariable Integer id) {
    //     return petService.getPetById(id);
    // }

    // @PostMapping
    // public Mascota createMascota(@RequestBody Mascota mascota) {
    //     return petService.createPet(mascota);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<String>  updateMascota(@PathVariable Integer id, @RequestBody Mascota mascotaDetails) {
    //     Mascota mascota = petService.getPetById(id);
    //     if (mascota == null) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
    //     }
        
    //     mascota.setTipo_mascota(mascotaDetails.getTipo_mascota());
    //     mascota.setNombre(mascotaDetails.getNombre());
    //     mascota.setEdad(mascotaDetails.getEdad());
    //     mascota.setRaza(mascotaDetails.getRaza());
    //     mascota.setPeso(mascotaDetails.getPeso());
    //     mascota.setTamano(mascotaDetails.getTamano());
    //     mascota.setSexo(mascotaDetails.getSexo());
    //     mascota.setEsterilizado(mascotaDetails.getEsterilizado());
    //     mascota.setDescripcion_mascota(mascotaDetails.getDescripcion_mascota());
    //     mascota.setInfo_cuidado(mascotaDetails.getInfo_cuidado());
    //     mascota.setFoto_mascota(mascotaDetails.getFoto_mascota());

    //     petService.updatePet(id, mascotaDetails);
       
    //     return ResponseEntity.ok("Mascota actualizada exitosamente");
       
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<String> deleteMascota(@PathVariable Integer id) {
    //     Mascota mascota = petService.getPetById(id);
    //     if (mascota == null) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
    //     }
        
    //     petService.deletePet(id);
    //     return ResponseEntity.ok("Mascota eliminada exitosamente");
    //     }
}
