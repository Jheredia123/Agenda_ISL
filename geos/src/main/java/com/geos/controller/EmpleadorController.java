package com.geos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geos.entity.Empleador;
import com.geos.service.IEmpleadorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("geos/empleadores")
public class EmpleadorController {
	  @Autowired
	    private IEmpleadorService empleadorService;

	    @GetMapping
	    public List<Empleador> getAllEmpleadores() {
	        return empleadorService.getAllEmpleadores();
	    }

	    @PostMapping
	    public Empleador createEmpleador(@RequestBody Empleador empleador) {
	        return empleadorService.createEmpleador(empleador);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Empleador> getEmpleadorById(@PathVariable Integer id) {
	        return empleadorService.getEmpleadorById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	    

	    @GetMapping("/buscarPorRut/{rut}")
	    public ResponseEntity<Empleador> buscarPorRut(@PathVariable String rut) {
	        Empleador empleador = empleadorService.buscarPorRut(rut);
	        if (empleador != null) {
	            return ResponseEntity.ok(empleador);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Empleador> updateEmpleador(@PathVariable Integer id, @RequestBody Empleador empleadorDetails) {
	        try {
	            Empleador updatedEmpleador = empleadorService.updateEmpleador(id, empleadorDetails);
	            return ResponseEntity.ok(updatedEmpleador);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmpleador(@PathVariable Integer id) {
	        try {
	            empleadorService.deleteEmpleador(id);
	            return ResponseEntity.ok().build();
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
