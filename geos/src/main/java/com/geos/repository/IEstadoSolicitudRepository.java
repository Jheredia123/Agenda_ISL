package com.geos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geos.entity.EstadoSolicitud;

public interface IEstadoSolicitudRepository extends JpaRepository<EstadoSolicitud, Integer> {

}
