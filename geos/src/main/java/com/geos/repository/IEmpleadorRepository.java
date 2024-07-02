package com.geos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geos.entity.Empleador;

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {
    // Puedes definir métodos de consulta personalizados aquí si es necesario

    Empleador findByRut(String rut);
}