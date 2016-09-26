package com.aula.virtual.domain;
// Generated 24-sep-2016 8:54:56 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Anio generated by hbm2java
 */
@Entity
@Table(name = "anio", catalog = "AULA_VIRTUAL")
public class Anio implements java.io.Serializable {

	private static final long serialVersionUID = -4938529430824519856L;
	private Integer idAnio;
	private String descripcion;

	public Anio() {
	}

	public Anio(String descripcion) {
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_ANIO", unique = true, nullable = false)
	public Integer getIdAnio() {
		return this.idAnio;
	}

	public void setIdAnio(Integer idAnio) {
		this.idAnio = idAnio;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 45)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}