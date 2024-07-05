package com.geos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geos.entity.Empleador;
import com.geos.entity.Trabajador;
import com.geos.service.ITrabajadorService;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/geos/trabajadores")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService trabajadorService;

	@GetMapping("/")
	public List<Trabajador> obtenerTodosLosTrabajadores() {
		return trabajadorService.obtenerTodosLosTrabajadores();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trabajador> getTrabajadorById(@PathVariable Integer id) {
	    Optional<Trabajador> trabajador = trabajadorService.obtenerTrabajadorPorId(id);
	    return trabajador.map(ResponseEntity::ok)
	                    .orElse(ResponseEntity.notFound().build());
	}

    @GetMapping("/buscarPorRut/{rut}")
    public ResponseEntity<Trabajador> buscarPorRut(@PathVariable String rut) {
    	Trabajador trabajador = trabajadorService.buscarPorRut(rut);
        if (trabajador != null) {
            return ResponseEntity.ok(trabajador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
	@PostMapping("/")
	public ResponseEntity<Trabajador> guardarTrabajador(@RequestBody Trabajador trabajador) {
		Trabajador nuevoTrabajador = trabajadorService.guardarTrabajador(trabajador);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTrabajador);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTrabajador(@PathVariable Integer id) {
		trabajadorService.eliminarTrabajadorPorId(id);
		return ResponseEntity.noContent().build();
	}

	// Otros métodos según sea necesario

}
