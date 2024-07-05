package com.geos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geos.entity.Examen;
import com.geos.service.IExamenService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/geos/examen")
public class ExamenController {
	
	@Autowired
	IExamenService examenService;
	
    @GetMapping
    public List<Examen> getAllExamen() {
        return examenService.getAllExamen();
    }

    @GetMapping("/buscarPorBateria/{idBateria}")
    public List<Examen> buscarPorIdBateria(@PathVariable Integer idBateria) {
        return examenService.buscarPorIdBateria(idBateria);
    }

}
