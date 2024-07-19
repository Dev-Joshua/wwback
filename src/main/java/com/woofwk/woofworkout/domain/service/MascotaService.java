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

    //Obtener mascotas
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    //Obtener mascota por ID
    public Mascota getMascotaById(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    //Crear una nueva mascota
    public Mascota createMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    //Actualizar una mascota existente
    public Mascota updateMascota(Long id, Mascota mascotaDetails) {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        if (mascota != null) {
            mascota.setNombre(mascotaDetails.getNombre());
            mascota.setTipo_mascota(mascotaDetails.getTipo_mascota());
            mascota.setRaza(mascotaDetails.getRaza());
            mascota.setEdad(mascotaDetails.getEdad());
            mascota.setPeso(mascotaDetails.getPeso());
            mascota.setEsterilizado(mascotaDetails.getEsterilizado());
            mascota.setDescripcion_mascota(mascotaDetails.getDescripcion_mascota());
            mascota.setInfo_cuidado(mascotaDetails.getInfo_cuidado());
            // mascota.setUsuario(mascotaDetails.getUsuario());

            return mascotaRepository.save(mascota);
        }
        return null;
    }

    //Eliminar una mascota
    public boolean deleteMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        if (mascota != null) {
            mascotaRepository.delete(mascota);
            return true;
        }
        return false;
    }
}
