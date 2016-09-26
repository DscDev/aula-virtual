package com.aula.virtual.response;

import java.io.Serializable;

public class AnioAsignaturaResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3879932701261837907L;
	private int idAnio;
	private int idAsignatura;
	private String descripcion;

	public int getIdAnio() {
		return idAnio;
	}

	public void setIdAnio(int idAnio) {
		this.idAnio = idAnio;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String idDescripcion) {
		this.descripcion = idDescripcion;
	}

}
