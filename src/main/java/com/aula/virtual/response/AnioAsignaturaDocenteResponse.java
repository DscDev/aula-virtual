package com.aula.virtual.response;

import java.io.Serializable;

public class AnioAsignaturaDocenteResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2179425653280240502L;
	private int idAnio;
	private int idAsignatura;
	private int idDocente;
	private String nombre;
	private String apellido;

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

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
