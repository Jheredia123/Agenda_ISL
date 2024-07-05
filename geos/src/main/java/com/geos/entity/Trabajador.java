package com.geos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRABAJADOR")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTRABAJADOR")
    private Integer idTrabajador;

    @Column(name = "RUT", unique = true, nullable = false, length = 255)
    private String rut;

    @Column(name = "NOMBRES", nullable = false, length = 255)
    private String nombres;

    @Column(name = "APELLIDOS", nullable = false, length = 255)
    private String apellidos;

    @Column(name = "VIGENTE", nullable = false)
    private boolean vigente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDEMPLEADOR")
    private Empleador empleador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ARCHIVO", nullable = true)
    private Archivo archivo;

    // Constructores, getters y setters

    public Trabajador() {
        // Constructor vacío requerido por JPA
    }

    // Getters y setters para todas las propiedades
    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    // toString, equals y hashCode según sea necesario
}
