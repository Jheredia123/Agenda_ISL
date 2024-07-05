package com.geos.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

@Entity
@Table(name = "PRESTADOR")
public class Prestador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPRESTADOR")
	private int idPrestador;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "DIRECCION", nullable = false)
	private String direccion;

	@Column(name = "FONO", nullable = false)
	private String fono;

	@Column(name = "CONTACTO", nullable = false)
	private String contacto;

	@Column(name = "CORREO", nullable = false)
	private String correo;

	@Column(name = "REGION", nullable = false)
	private String region;

	@Column(name = "COMUNA", nullable = false)
	private String comuna;

	@Column(name = "FECHAINICIO", nullable = false)
	private Date fechaInicio;

	@Column(name = "FECHAFIN", nullable = false)

	private Date fechaFin;

	@Column(name = "VIGENTE", nullable = false)
	private boolean vigente;

	// Getters y Setters

	public int getIdPrestador() {
		return idPrestador;
	}

	public void setIdPrestador(int idPrestador) {
		this.idPrestador = idPrestador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
}
