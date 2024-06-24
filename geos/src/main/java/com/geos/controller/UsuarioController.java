package com.geos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geos.dto.UsuarioDTO;
import com.geos.service.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/geos/usuarios")
public class UsuarioController {

	@Autowired
	IUsuarioService service;

	/**
	 * get all the categories
	 * 
	 * @return
	 */
	@GetMapping("/ejemplo")
	public String ejemplo() {

		return "Este es un ejemplo";
	}

	/**
	 * get all the categories
	 * 
	 * @return
	 */
	@GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>>  getAllUsuarios() {
        return service.findAllUsuarios();
    }

}
