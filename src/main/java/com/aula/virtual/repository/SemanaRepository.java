package com.aula.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.virtual.domain.Semana;

public interface SemanaRepository extends JpaRepository<Semana, Long> {

	public Semana findSemanaByIdSemana(int idSemana);

}
