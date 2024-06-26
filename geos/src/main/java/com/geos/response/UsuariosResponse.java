package com.geos.response;

import java.util.List;

import com.geos.entity.Usuarios;

import lombok.Data;

@Data
public class UsuariosResponse {
	
	private List<Usuarios> usuarios;
	
}
