package com.geos.service;

import java.util.List;

import com.geos.dto.SolicitudDTO;
import com.geos.entity.Solicitud;

public interface ISolicitudService {

	List<Solicitud> findAll();

	Solicitud findById(int id);

	Solicitud save(SolicitudDTO solicitud);

	Solicitud update(int id, Solicitud solicitud);

	boolean delete(int id);



}
