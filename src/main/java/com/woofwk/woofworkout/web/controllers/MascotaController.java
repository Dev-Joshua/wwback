package com.woofwk.woofworkout.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return mascotaService.getAllMasccotas();
    }
}
