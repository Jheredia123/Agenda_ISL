package com.geos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.geos.entity.Empleador;
import com.geos.entity.Trabajador;

public interface ITrabajadorService {

	List<Trabajador> obtenerTodosLosTrabajadores();

	Optional<Trabajador> obtenerTrabajadorPorId(Integer id);

	Trabajador guardarTrabajador(Trabajador trabajador);

	void eliminarTrabajadorPorId(Integer id);

	Trabajador buscarPorRut(String rut);

}
