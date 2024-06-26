package com.geos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.geos.dto.UsuarioDTO;

public interface IUsuarioService {

	ResponseEntity<List<UsuarioDTO>> findAllUsuarios();
}
