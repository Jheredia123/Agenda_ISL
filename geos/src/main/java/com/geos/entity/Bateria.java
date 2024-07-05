package com.geos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BATERIA")
public class Bateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBATTERIA")
    private int idBateria;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "RECOMENDACION", nullable = false)
    private String recomendacion;

    @Column(name = "JORNADA", nullable = false)
    private String jornada;

    @Column(name = "VIGENTE", nullable = false)
    private boolean vigente;

    @ManyToOne
    @JoinColumn(name = "IDPRESTADOR", referencedColumnName = "IDPRESTADOR")
    private Prestador prestador;

    // Getters and Setters

    public int getIdBatteria() {
        return idBateria;
    }

    public void setIdBatteria(int idBatteria) {
        this.idBateria = idBatteria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }
}