package com.geos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geos.entity.Bateria;
import com.geos.service.IBateriaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("geos/bateria")
public class BateriaController {

	@Autowired
	IBateriaService bateriaService;
	
	   @GetMapping
	    public List<Bateria> getAllEmpleadores() {
	        return bateriaService.getAllBateria();
	    }
}
