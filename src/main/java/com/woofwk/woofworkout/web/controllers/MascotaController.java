package com.woofwk.woofworkout.web.controllers;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woofwk.woofworkout.domain.service.MascotaService;
import com.woofwk.woofworkout.models.Mascota;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
     @Autowired
    private MascotaService petService;

    // Metodos para realizar un CRUD
    @GetMapping
    public List<Mascota> getAllData() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return petService.createPet(mascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  updateMascota(@PathVariable Long id, @RequestBody Mascota mascotaDetails) {
        Mascota mascota = petService.getPetById(id);
        if (mascota == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
        }
        
        mascota.setTipo_mascota(mascotaDetails.getTipo_mascota());
        mascota.setNombre(mascotaDetails.getNombre());
        mascota.setEdad(mascotaDetails.getEdad());
        mascota.setRaza(mascotaDetails.getRaza());
        mascota.setPeso(mascotaDetails.getPeso());
        mascota.setTamano(mascotaDetails.getTamano());
        mascota.setSexo(mascotaDetails.getSexo());
        mascota.setEsterilizado(mascotaDetails.getEsterilizado());
        mascota.setDescripcion_mascota(mascotaDetails.getDescripcion_mascota());
        mascota.setInfo_cuidado(mascotaDetails.getInfo_cuidado());
        mascota.setFoto_mascota(mascotaDetails.getFoto_mascota());

        petService.updatePet(id, mascotaDetails);
       
        return ResponseEntity.ok("Mascota actualizada exitosamente");
       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMascota(@PathVariable Long id) {
        Mascota mascota = petService.getPetById(id);
        if (mascota == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
        }
        
        petService.deletePet(id);
        return ResponseEntity.ok("Mascota eliminada exitosamente");
        }
}
