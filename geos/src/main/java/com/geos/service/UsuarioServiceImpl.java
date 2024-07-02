package com.geos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.geos.dto.UsuarioDTO;
import com.geos.entity.Usuarios;
import com.geos.repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuariosRepository;

	@Override
	@Transactional
	public ResponseEntity<List<UsuarioDTO>> findAllUsuarios() {
		try {
			List<Usuarios> usuarios = (List<Usuarios>) usuariosRepository.findAll();

			List<UsuarioDTO> usuarioDTOs = new ArrayList();
			for (Usuarios usuario : usuarios) {
				UsuarioDTO usuDTO = new UsuarioDTO();

				usuDTO = this.convertToDTO(usuario);
				usuarioDTOs.add(usuDTO);
			}

			return ResponseEntity.ok(usuarioDTOs);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

	}

	private UsuarioDTO convertToDTO(Usuarios usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getIdUsuario());
		dto.setRut(usuario.getRut());
		dto.setNombres(usuario.getNombres());
		dto.setApellidos(usuario.getApellidos());
		dto.setRegion(usuario.getRegion());
		dto.setComuna(usuario.getComuna());
		dto.setTipo(usuario.getTipo());
		dto.setEmail(usuario.getEmail());
		dto.setFono(usuario.getFono());
		dto.setClave(usuario.getClave());
		dto.setVigente(usuario.isVigente());
		return dto;
	}

}
