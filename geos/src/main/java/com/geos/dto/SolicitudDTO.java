package com.geos.dto;

import java.util.Date;
import java.util.List;

public class SolicitudDTO {
	
	 private String run;
	    private String nombres;
	    private String apellidos;
	    private Date fechaCreacion;
	    private String rutEmpresa;
	    private String razonSocial;
	    private String direccion;
	    private String region;
	    private String comuna;
	    private String actividadEconomica;
	    private String descripcion;
	    private List<TrabajadorDTO> trabajadores;
	    private String bateria;
	    private List<ExamenDTO> examenes;
		public String getRun() {
			return run;
		}
		public void setRun(String run) {
			this.run = run;
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
		public Date getFechaCreacion() {
			return fechaCreacion;
		}
		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
		public String getRutEmpresa() {
			return rutEmpresa;
		}
		public void setRutEmpresa(String rutEmpresa) {
			this.rutEmpresa = rutEmpresa;
		}
		public String getRazonSocial() {
			return razonSocial;
		}
		public void setRazonSocial(String razonSocial) {
			this.razonSocial = razonSocial;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
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
		public String getActividadEconomica() {
			return actividadEconomica;
		}
		public void setActividadEconomica(String actividadEconomica) {
			this.actividadEconomica = actividadEconomica;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public List<TrabajadorDTO> getTrabajadores() {
			return trabajadores;
		}
		public void setTrabajadores(List<TrabajadorDTO> trabajadores) {
			this.trabajadores = trabajadores;
		}
		public String getBateria() {
			return bateria;
		}
		public void setBateria(String bateria) {
			this.bateria = bateria;
		}
		public List<ExamenDTO> getExamenes() {
			return examenes;
		}
		public void setExamenes(List<ExamenDTO> examenes) {
			this.examenes = examenes;
		}

	    // Getters and Setters
	    
	    
}
