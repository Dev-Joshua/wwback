package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.MascotaRepository;
import com.woofwk.woofworkout.models.Mascota;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMasccotas() {
        return mascotaRepository.findAll();
    }
}
