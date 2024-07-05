package com.geos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.geos.entity.Trabajador;
import com.geos.repository.TrabajadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;

	public List<Trabajador> obtenerTodosLosTrabajadores() {
		return trabajadorRepository.findAll();
	}

	public Trabajador guardarTrabajador(Trabajador trabajador) {
		return trabajadorRepository.save(trabajador);
	}

	public Optional<Trabajador> obtenerTrabajadorPorId(Integer id) {
		return trabajadorRepository.findById(id);
	}

	public void eliminarTrabajadorPorId(Integer id) {
		trabajadorRepository.deleteById(id);
	}

	@Override
	public Trabajador buscarPorRut(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	// Otros métodos según sea necesario

}
