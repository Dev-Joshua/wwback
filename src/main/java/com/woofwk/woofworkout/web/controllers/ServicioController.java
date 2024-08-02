package com.woofwk.woofworkout.web.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.woofwk.woofworkout.domain.service.ServicioService;
import com.woofwk.woofworkout.models.Servicio;
import com.woofwk.woofworkout.models.Usuario;


@Controller
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServicioService serviceService;


     // Metodo para obtener los servicios de la base de datos
    @GetMapping({"", "/"})
    public String mostrarServicios(Model model) {
        List<Servicio> servicios = serviceService.getAll();
        servicios.sort(Comparator.comparing(Servicio::getId_servicio).reversed());
        model.addAttribute("servicios", servicios);

        return "servicios/index";
    }


    // Metodos para API REST

    /// Metodos para realizar un CRUD
    // @GetMapping
    // public List<Servicio> getAllData() {
    //     return serviceService.findAll();
    // }

    // @GetMapping("/{id}")
    // public Servicio getServiceById(@PathVariable Long id) {
    //     return serviceService.findById(id);
    // }

    // @PostMapping
    // public Servicio createServicio(@RequestBody Servicio servicio) {
    //     return serviceService.save(servicio);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteServicio(@PathVariable Long id) {
    //     serviceService.deleteById(id);
    // }
}
