package com.woofwk.woofworkout.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.ServicioRepository;
import com.woofwk.woofworkout.models.Servicio;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository serviceRepository;

    public List<Servicio> findAll() {
        return serviceRepository.findAll();
    }

    public Servicio findById(Long id) {
        Optional<Servicio> servicio = serviceRepository.findById(id);
        return servicio.orElse(null);
    }

    public Servicio save(Servicio servicio) {
        return serviceRepository.save(servicio);
    }

    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }
}
