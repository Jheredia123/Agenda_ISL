package com.geos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geos.dto.SolicitudDTO;
import com.geos.entity.Empleador;
import com.geos.entity.EstadoSolicitud;
import com.geos.entity.Solicitud;
import com.geos.entity.Usuarios;
import com.geos.repository.IEmpleadorRepository;
import com.geos.repository.IEstadoSolicitudRepository;
import com.geos.repository.ISolicitudRepository;
import com.geos.repository.IUsuarioRepository;

@Service
public class SolicitudServiceImpl implements ISolicitudService {
	
	@Autowired
	private ISolicitudRepository solicitudRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private IEmpleadorRepository empleadorRepository;
	
	@Autowired
	private IEstadoSolicitudRepository estadoSolicitudRepository;
		
	
	@Override
	public List<Solicitud> findAll() {
		return solicitudRepository.findAll();
	}

	@Override
	public Solicitud findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solicitud save(SolicitudDTO solicitudDto) {
		
		Solicitud solicitud = new Solicitud();
        
        solicitud.setFechaSolicitud(solicitudDto.getFechaCreacion());        
        
        // Transformar los campos del DTO a la entidad
        // Asumiendo que ya tienes métodos para buscar las entidades relacionadas
        solicitud.setFechaSolicitud(solicitudDto.getFechaCreacion());
        Usuarios usuario = usuarioRepository.findByRut(solicitudDto.getRun());
        solicitud.setUsuario(usuario);
        
        Empleador empleador = empleadorRepository.findByRut(solicitudDto.getRutEmpresa());
        solicitud.setEmpleador(empleador);
        
        solicitud.setNombre(solicitudDto.getNombres() + " " + solicitudDto.getApellidos());
        solicitud.setRazon(solicitudDto.getRazonSocial());
        
        solicitud.setDireccionPrestador(solicitudDto.getDireccion());

        
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud();
      
        estadoSolicitud.setIdEstado(1);
	    estadoSolicitud.setNombreEstado("BORRADOR");
	    estadoSolicitud.setEstado("ACTIVO");
	      
	    solicitud.setEstadoSolicitud(estadoSolicitud);
	    
	    solicitud.setEstado(estadoSolicitud.getNombreEstado());
	    

        return solicitudRepository.save(solicitud);

	}

	@Override
	public Solicitud update(int id, Solicitud solicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
