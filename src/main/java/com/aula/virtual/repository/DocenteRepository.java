package com.aula.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.virtual.domain.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {

	public Docente findDocenteByIdDocente(int idDocente);

	public Docente findDocenteByIdUsuario(int idUsuario);

}
