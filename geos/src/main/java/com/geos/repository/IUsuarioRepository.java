package com.geos.repository;

import org.springframework.data.repository.CrudRepository;

import com.geos.entity.Usuarios;

public interface IUsuarioRepository extends CrudRepository<Usuarios, Integer> {

	Usuarios findByRut(String rut);

}
