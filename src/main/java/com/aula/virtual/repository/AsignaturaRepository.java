package com.aula.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.virtual.domain.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

	public Asignatura findAsignaturaByIdAsignatura(int idAsignatura);

}
