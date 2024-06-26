package com.geos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private Long id;
    private String rut;
    private String nombres;
    private String apellidos;
    private String region;
    private String comuna;
    private String tipo;
    private String email;
    private String fono;
    private String clave;
    private String estado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFono() {
		return fono;
	}
	public void setFono(String fono) {
		this.fono = fono;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setIdusuario(Long idUsuario) {
		// TODO Auto-generated method stub
		
	}

    
    
    
    
    
}
