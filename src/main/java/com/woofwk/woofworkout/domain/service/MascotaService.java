package com.woofwk.woofworkout.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woofwk.woofworkout.domain.repository.MascotaRepository;
import com.woofwk.woofworkout.models.Mascota;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository petRepository;

    //Obtener mascotas
    public List<Mascota> getAllPets() {
        return petRepository.findAll();
    }

    //Obtener mascota por ID
    public Mascota getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    //Crear una nueva mascota
    public Mascota createPet(Mascota mascota) {
        return petRepository.save(mascota);
    }

    //Actualizar una mascota existente
    public Mascota updatePet(Long id, Mascota mascotaDetails) {
        Mascota pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            pet.setNombre(mascotaDetails.getNombre());
            pet.setTipo_mascota(mascotaDetails.getTipo_mascota());
            pet.setRaza(mascotaDetails.getRaza());
            pet.setEdad(mascotaDetails.getEdad());
            pet.setPeso(mascotaDetails.getPeso());
            pet.setEsterilizado(mascotaDetails.getEsterilizado());
            pet.setDescripcion_mascota(mascotaDetails.getDescripcion_mascota());
            pet.setInfo_cuidado(mascotaDetails.getInfo_cuidado());
            // mascota.setUsuario(mascotaDetails.getUsuario());

            return petRepository.save(pet);
        }
        return null;
    }

    //Eliminar una mascota
    public boolean deletePet(Long id) {
        Mascota pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            petRepository.delete(pet);
            return true;
        }
        return false;
    }
}
