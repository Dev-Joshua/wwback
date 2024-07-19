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
    private SolicitudService requestServicce;

    // Metodos
    @GetMapping
    public List<Solicitud> getAllRequests() {
        return requestServicce.findAll();
    }

    @GetMapping("/{id}")
    public Solicitud getRequestById(@PathVariable Long id) {
        return requestServicce.findById(id);
    }

    @PostMapping
    public Solicitud createRequest(@RequestBody Solicitud solicitud) {
        return requestServicce.save(solicitud);
    }

    // @DeleteMapping("/{id}")
    // public void deleteSolicitud(@PathVariable Long id) {
    //     solicitudService.deleteById(id);
    // }
}
