package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.PagoRepository;
import com.woofwk.woofworkout.models.Pago;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    // public Pago getPagoById(Long id) {
    //     return pagoRepository.findById(id).orElse(null);
    // }

    // public Pago savePago(Pago pago) {
    //     return pagoRepository.save(pago);
    // }

    // public void deletePago(Long id) {
    //     pagoRepository.deleteById(id);
    // }
}
