package com.geos.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "SOLICITUD")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSOLICITUD")
    private int idSolicitud;

    @Column(name = "FECHASOLICITUD", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "IDEMPLEADOR", referencedColumnName = "IDEMPLEADOR")
    private Empleador empleador;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "RAZON", nullable = false)
    private String razon;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "IDPRESTADOR", referencedColumnName = "IDPRESTADOR")
    private Prestador prestador;

    @Column(name = "DIRECCION_PRESTADOR")
    private String direccionPrestador;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    private EstadoSolicitud estadoSolicitud;

    @ManyToOne
    @JoinColumn(name = "ID_ARCHIVO", referencedColumnName = "ID_ARCHIVO")
    private Archivo archivo;

    // Getters and Setters
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public String getDireccionPrestador() {
        return direccionPrestador;
    }

    public void setDireccionPrestador(String direccionPrestador) {
        this.direccionPrestador = direccionPrestador;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
}