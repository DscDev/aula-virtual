package com.aula.virtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.virtual.domain.Anio;

public interface AnioRepository extends JpaRepository<Anio, Long> {

	public Anio findAnioByIdAnio(int idAnio);

}
