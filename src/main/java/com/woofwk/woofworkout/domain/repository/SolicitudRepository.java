package com.woofwk.woofworkout.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woofwk.woofworkout.models.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long>{

}