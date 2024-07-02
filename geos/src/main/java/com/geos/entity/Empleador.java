package com.geos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "EMPLEADOR")
public class Empleador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleador")
    private Integer idEmpleador;

    @Column(name = "rut", unique = true, nullable = false)
    private String rut;

    @Column(name = "razonsocial", nullable = false)
    private String razonSocial;

    @Column(name = "contacto", nullable = false)
    private String contacto;

    @Column(name = "fono", nullable = false)
    private String fono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "estado", nullable = false)
    private String estado;

    // Getters and Setters
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

