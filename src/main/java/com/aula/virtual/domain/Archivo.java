package com.aula.virtual.domain;
// Generated 24-sep-2016 8:54:56 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Archivo generated by hbm2java
 */
@Entity
@Table(name = "archivo", catalog = "AULA_VIRTUAL")
public class Archivo implements java.io.Serializable {

	private ArchivoId id;
	private int idSemana;
	private String ruta;

	public Archivo() {
	}

	public Archivo(ArchivoId id, int idSemana, String ruta) {
		this.id = id;
		this.idSemana = idSemana;
		this.ruta = ruta;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idArchivo", column = @Column(name = "ID_ARCHIVO", nullable = false)),
			@AttributeOverride(name = "idAnio", column = @Column(name = "ID_ANIO", nullable = false)),
			@AttributeOverride(name = "idAsignatura", column = @Column(name = "ID_ASIGNATURA", nullable = false)),
			@AttributeOverride(name = "idDocente", column = @Column(name = "ID_DOCENTE", nullable = false)) })
	public ArchivoId getId() {
		return this.id;
	}

	public void setId(ArchivoId id) {
		this.id = id;
	}

	@Column(name = "ID_SEMANA", nullable = false)
	public int getIdSemana() {
		return this.idSemana;
	}

	public void setIdSemana(int idSemana) {
		this.idSemana = idSemana;
	}

	@Column(name = "RUTA", nullable = false, length = 45)
	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
