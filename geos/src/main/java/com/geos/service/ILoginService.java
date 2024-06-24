package com.geos.service;

import org.springframework.http.ResponseEntity;

import com.geos.dto.UsuarioDTO;

public interface ILoginService {

	ResponseEntity<UsuarioDTO> loginUsuario(String rut, String password);

}
