package com.woofwk.woofworkout.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woofwk.woofworkout.models.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long>{

}
