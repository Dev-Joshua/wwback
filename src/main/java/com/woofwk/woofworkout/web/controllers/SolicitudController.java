package com.woofwk.woofworkout.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woofwk.woofworkout.domain.service.SolicitudService;
import com.woofwk.woofworkout.models.Solicitud;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public List<Solicitud> getAllSolicitudes() {
        return solicitudService.findAll();
    }

    // @GetMapping("/{id}")
    // public Solicitud getSolicitudById(@PathVariable Long id) {
    //     return solicitudService.findById(id);
    // }

    // @PostMapping
    // public Solicitud createSolicitud(@RequestBody Solicitud solicitud) {
    //     return solicitudService.save(solicitud);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteSolicitud(@PathVariable Long id) {
    //     solicitudService.deleteById(id);
    // }
}
