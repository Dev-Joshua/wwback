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

import com.woofwk.woofworkout.domain.service.PagoService;
import com.woofwk.woofworkout.models.Pago;

@RestController
@RequestMapping("/pagos")
public class PagoController {
     @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    // @GetMapping("/{id}")
    // public Pago getPagoById(@PathVariable Long id) {
    //     return pagoService.getPagoById(id);
    // }

    // @PostMapping
    // public Pago savePago(@RequestBody Pago pago) {
    //     return pagoService.savePago(pago);
    // }

    // @DeleteMapping("/{id}")
    // public void deletePago(@PathVariable Long id) {
    //     pagoService.deletePago(id);
    // }
}
