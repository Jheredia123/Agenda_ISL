package com.geos.service;

import java.util.List;
import java.util.Optional;

import com.geos.entity.Empleador;

public interface IEmpleadorService {
	
    List<Empleador> getAllEmpleadores();
    Optional<Empleador> getEmpleadorById(Integer id);
    Empleador buscarPorRut(String rut);
    Empleador createEmpleador(Empleador empleador);
    Empleador updateEmpleador(Integer id, Empleador empleadorDetails);
    void deleteEmpleador(Integer id);

}
