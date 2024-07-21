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
    private PagoService payService;

    //Metodos
    @GetMapping
    public List<Pago> getAllPayments() {
        return payService.getAllPays();
    }

    @GetMapping("/{id}")
    public Pago getPaymentById(@PathVariable Long id) {
        return payService.getPayById(id);
    }

    @PostMapping
    public Pago savePayment(@RequestBody Pago pay) {
        return payService.savePay(pay);
    }

    // @DeleteMapping("/{id}")
    // public void deletePago(@PathVariable Long id) {
    //     payService.deletePago(id);
    // }
}
