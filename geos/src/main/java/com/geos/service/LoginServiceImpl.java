package com.geos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.geos.dto.UsuarioDTO;
import com.geos.entity.Usuarios;
import com.geos.exception.InvalidRutException;
import com.geos.repository.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IUsuarioRepository usuariosRepository;

	@Override
	@Transactional
	public ResponseEntity<UsuarioDTO> loginUsuario(String rut, String password) {

		try {
			if (!isValidRUT(rut)) {
				throw new InvalidRutException("RUT inválido");
			}

			Usuarios usuario = usuariosRepository.findByRut(rut);
			UsuarioDTO usuDTO = new UsuarioDTO();
			if (usuario != null & password.equals(usuario.getClave())) {

				usuDTO = this.convertToDTO(usuario);

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

			return ResponseEntity.ok(usuDTO);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	private UsuarioDTO convertToDTO(Usuarios usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setIdusuario(usuario.getIdUsuario());
		dto.setRut(usuario.getRut());
		dto.setNombres(usuario.getNombres());
		dto.setApellidos(usuario.getApellidos());
		dto.setRegion(usuario.getRegion());
		dto.setComuna(usuario.getComuna());
		dto.setTipo(usuario.getTipo());
		dto.setEmail(usuario.getEmail());
		dto.setFono(usuario.getFono());
		dto.setClave(usuario.getClave());
		dto.setEstado(usuario.getEstado());
		return dto;
	}

	private boolean isValidRUT(String rut) {
		if (rut == null || rut.isEmpty()) {
			return false;
		}

		// Lógica de validación del RUT
		rut = rut.toUpperCase();
		rut = rut.replace(".", "").replace("-", "");
		int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
		char dv = rut.charAt(rut.length() - 1);

		int m = 0, s = 1;
		for (; rutAux != 0; rutAux /= 10) {
			s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		}
		char expectedDV = (char) (s != 0 ? s + 47 : 75);

		return dv == expectedDV;
	}

}
