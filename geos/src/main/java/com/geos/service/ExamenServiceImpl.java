package com.geos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geos.entity.Examen;
import com.geos.repository.IExamenRepository;

@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenRepository examenRepository;

	@Override
	public List<Examen> getAllExamen() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Examen> buscarPorIdBateria(Integer idBateria) {
		return examenRepository.findByBateriaIdBateria(idBateria);
	}

}
