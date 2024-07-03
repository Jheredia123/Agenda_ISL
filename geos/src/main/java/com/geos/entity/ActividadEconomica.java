package com.geos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACTIVIDADECONOMICA")
public class ActividadEconomica {

    @Id
    @Column(name = "CODIGOAE", nullable = false, length = 255)
    private String codigoAE;

    @Column(name = "DESCRIPCION", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "ESTADO", nullable = false, length = 255)
    private String estado;

    // Getters and setters
    public String getCodigoAE() {
        return codigoAE;
    }

    public void setCodigoAE(String codigoAE) {
        this.codigoAE = codigoAE;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}