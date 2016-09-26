package com.aula.virtual.domain;
// Generated 24-sep-2016 8:54:56 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Asignatura generated by hbm2java
 */
@Entity
@Table(name = "asignatura", catalog = "AULA_VIRTUAL")
public class Asignatura implements java.io.Serializable {

	private Integer idAsignatura;
	private String descripcion;

	public Asignatura() {
	}

	public Asignatura(String descripcion) {
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_ASIGNATURA", unique = true, nullable = false)
	public Integer getIdAsignatura() {
		return this.idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 45)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
