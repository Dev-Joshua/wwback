package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.SolicitudRepository;
import com.woofwk.woofworkout.models.Solicitud;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    public Solicitud findById(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    // public void deleteById(Long id) {
    //     solicitudRepository.deleteById(id);
    // }
}
