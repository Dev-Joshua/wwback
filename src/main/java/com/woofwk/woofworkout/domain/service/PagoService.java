package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.PagoRepository;
import com.woofwk.woofworkout.models.Pago;

@Service
public class PagoService {
    @Autowired
    private PagoRepository payRepository;

    public List<Pago> getAllPays() {
        return payRepository.findAll();
    }

    public Pago getPayById(Long id) {
        return payRepository.findById(id).orElse(null);
    }

    public Pago savePay(Pago pago) {
        return payRepository.save(pago);
    }

    // public void deletePago(Long id) {
    //     payRepository.deleteById(id);
    // }
}
