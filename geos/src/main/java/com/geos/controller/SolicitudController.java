package com.geos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import com.geos.dto.SolicitudDTO;
import com.geos.entity.Solicitud;
import com.geos.service.ISolicitudService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/geos/solicitudes")
public class SolicitudController {

	@Autowired
	private ISolicitudService solicitudService;

	@GetMapping
	public ResponseEntity<List<Solicitud>> getAllSolicitudes() {
		List<Solicitud> solicitudes = solicitudService.findAll();
		return new ResponseEntity<>(solicitudes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Solicitud> getSolicitudById(@PathVariable("id") int id) {
		Solicitud solicitud = solicitudService.findById(id);
		if (solicitud != null) {
			return new ResponseEntity<>(solicitud, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	 @PostMapping
	    public ResponseEntity<Solicitud> createSolicitud(@RequestBody SolicitudDTO solicitud) {
	        try {
	        	
	            Solicitud newSolicitud  =	solicitudService.save(solicitud);
	            
	            return new ResponseEntity<>(newSolicitud, HttpStatus.CREATED);
	        } catch (Exception e) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating solicitud", e);
	        }
	    }


	@PutMapping("/{id}")
	public ResponseEntity<Solicitud> updateSolicitud(@PathVariable("id") int id, @RequestBody Solicitud solicitud) {
		Solicitud updatedSolicitud = solicitudService.update(id, solicitud);
		if (updatedSolicitud != null) {
			return new ResponseEntity<>(updatedSolicitud, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSolicitud(@PathVariable("id") int id) {
		boolean isDeleted = solicitudService.delete(id);
		if (isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
