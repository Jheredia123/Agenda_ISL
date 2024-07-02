package com.geos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADOR")
public class Empleador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDEMPLEADOR")
	private Integer idEmpleador;

	@Column(name = "RUT", unique = true, nullable = false, length = 255)
	private String rut;

	@Column(name = "RAZONSOCIAL", nullable = false, length = 255)
	private String razonSocial;

	@Column(name = "CONTACTO", nullable = false, length = 255)
	private String contacto;

	@Column(name = "FONO", nullable = false, length = 255)
	private String fono;

	@Column(name = "CORREO", nullable = false, length = 255)
	private String correo;

	@Column(name = "TIPO", nullable = false, length = 255)
	private String tipo;

	@Column(name = "DIRECCION", nullable = false, length = 255)
	private String direccion;

	@Column(name = "REGION", nullable = false, length = 255)
	private String region;

	@Column(name = "COMUNA", nullable = false, length = 255)
	private String comuna;

	@Column(name = "CODIGOAEO", nullable = false, length = 255)
	private String codigoAE;

	@Column(name = "VIGENTE", nullable = false)
	private boolean vigente;

	// Getters and setters
	public Integer getIdEmpleador() {
		return idEmpleador;
	}

	public void setIdEmpleador(Integer idEmpleador) {
		this.idEmpleador = idEmpleador;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getCodigoAE() {
		return codigoAE;
	}

	public void setCodigoAE(String codigoAE) {
		this.codigoAE = codigoAE;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
}