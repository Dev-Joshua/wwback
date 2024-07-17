package com.woofwk.woofworkout.web.controllers;

import java.util.List;

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
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> getAllData() {
        return mascotaService.getAllMascotas();
    }

    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.createMascota(mascota);
    }

    @PutMapping("/{id}")
    public Mascota updateMascota(@PathVariable Long id, @RequestBody Mascota mascotaDetails) {
        return mascotaService.updateMascota(id, mascotaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        boolean isDeleted = mascotaService.deleteMascota(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
