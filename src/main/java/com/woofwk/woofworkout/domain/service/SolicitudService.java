package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.PagoRepository;
import com.woofwk.woofworkout.domain.repository.SolicitudRepository;
import com.woofwk.woofworkout.models.Pago;
import com.woofwk.woofworkout.models.Solicitud;

import jakarta.transaction.Transactional;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository requestRepository;

     @Autowired
    private PagoRepository payrepRepository;

    public List<Solicitud> getAll() {
        return requestRepository.findAll();
    }

    public Solicitud findByIdRequest(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Transactional
    public Solicitud createRequest(Solicitud request) {
        Pago pay = request.getPago();
        if (pay != null) {
            pay.setSolicitud(request);  // Establece la relación bidireccional
            payrepRepository.save(pay);
        }
        return requestRepository.save(request);
    }

    // public void deleteById(Long id) {
    //     requestRepository.deleteById(id);
    // }
}
