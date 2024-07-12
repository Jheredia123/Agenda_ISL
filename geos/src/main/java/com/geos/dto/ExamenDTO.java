package com.geos.dto;

public class ExamenDTO {
	   private int idExamen;
	    private String nombre;
	    private String evaluacion;
	    private BateriaDTO bateria;

	    // Getters and Setters
	    public int getIdExamen() {
	        return idExamen;
	    }

	    public void setIdExamen(int idExamen) {
	        this.idExamen = idExamen;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getEvaluacion() {
	        return evaluacion;
	    }

	    public void setEvaluacion(String evaluacion) {
	        this.evaluacion = evaluacion;
	    }

	    public BateriaDTO getBateria() {
	        return bateria;
	    }

	    public void setBateria(BateriaDTO bateria) {
	        this.bateria = bateria;
	    }
}
