package com.geos.dto;

public class BateriaDTO {
	
	 private int idBateria;
	    private String nombre;
	    private String recomendacion;
	    private String jornada;
	    private boolean vigente;
	    private int idPrestador;

	    // Getters and Setters
	    public int getIdBateria() {
	        return idBateria;
	    }

	    public void setIdBateria(int idBateria) {
	        this.idBateria = idBateria;
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

	    public int getIdPrestador() {
	        return idPrestador;
	    }

	    public void setIdPrestador(int idPrestador) {
	        this.idPrestador = idPrestador;
	    }

}
