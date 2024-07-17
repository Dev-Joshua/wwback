package com.woofwk.woofworkout.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.woofwk.woofworkout.domain.service.ServicioService;
import com.woofwk.woofworkout.models.Servicio;


@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> getAllData() {
        return servicioService.findAll();
    }
}
