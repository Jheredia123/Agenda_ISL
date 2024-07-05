package com.geos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geos.entity.Examen;

public interface IExamenRepository extends JpaRepository<Examen, Integer> {

	List<Examen> findByBateriaIdBateria(Integer idBateria);
}
