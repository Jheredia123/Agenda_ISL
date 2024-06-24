package com.geos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geos.dto.UsuarioDTO;
import com.geos.service.ILoginService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/geos/login")
public class LoginController {

	
	@Autowired
	ILoginService service;
	
	/**
	 * get all the categories
	 * 
	 * @return
	 */

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> getLogin(@RequestParam String rut, @RequestParam String password) {
        return service.loginUsuario(rut, password);
    }

	
}
