package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.SolicitudRepository;
import com.woofwk.woofworkout.models.Solicitud;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository requestRepository;

    public List<Solicitud> getAll() {
        return requestRepository.findAll();
    }

    public Solicitud findByIdRequest(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public Solicitud createRequest(Solicitud request) {
        return requestRepository.save(request);
    }

    // public void deleteById(Long id) {
    //     requestRepository.deleteById(id);
    // }
}
