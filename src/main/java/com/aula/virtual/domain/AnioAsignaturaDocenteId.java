package com.aula.virtual.domain;
// Generated 24-sep-2016 8:54:56 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AnioAsignaturaDocenteId generated by hbm2java
 */
@Embeddable
public class AnioAsignaturaDocenteId implements java.io.Serializable {

	private int idAnio;
	private int idAsignatura;
	private int idDocente;

	public AnioAsignaturaDocenteId() {
	}

	public AnioAsignaturaDocenteId(int idAnio, int idAsignatura, int idDocente) {
		this.idAnio = idAnio;
		this.idAsignatura = idAsignatura;
		this.idDocente = idDocente;
	}

	@Column(name = "ID_ANIO", nullable = false)
	public int getIdAnio() {
		return this.idAnio;
	}

	public void setIdAnio(int idAnio) {
		this.idAnio = idAnio;
	}

	@Column(name = "ID_ASIGNATURA", nullable = false)
	public int getIdAsignatura() {
		return this.idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Column(name = "ID_DOCENTE", nullable = false)
	public int getIdDocente() {
		return this.idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AnioAsignaturaDocenteId))
			return false;
		AnioAsignaturaDocenteId castOther = (AnioAsignaturaDocenteId) other;

		return (this.getIdAnio() == castOther.getIdAnio()) && (this.getIdAsignatura() == castOther.getIdAsignatura())
				&& (this.getIdDocente() == castOther.getIdDocente());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdAnio();
		result = 37 * result + this.getIdAsignatura();
		result = 37 * result + this.getIdDocente();
		return result;
	}

}