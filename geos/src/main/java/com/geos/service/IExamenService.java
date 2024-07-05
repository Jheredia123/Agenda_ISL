package com.geos.service;

import java.util.List;

import com.geos.entity.Examen;

public interface IExamenService {

	List<Examen> getAllExamen();

		List<Examen> buscarPorIdBateria(Integer idBateria);

}
