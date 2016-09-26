package com.aula.virtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aula.virtual.domain.AnioAsignatura;
import com.aula.virtual.domain.AnioAsignaturaId;

public interface AnioAsignaturaRepository extends JpaRepository<AnioAsignatura, Long> {

	public AnioAsignatura findAnioAsignaturaById(AnioAsignaturaId id);

	@Query(value = "SELECT * FROM ANIO_ASIGNATURA AA WHERE AA.ID_ANIO = :idAnio ", nativeQuery = true)
	public List<AnioAsignatura> findAllAsignaturaByIdAnio(@Param("idAnio") int idAnio);

	/*
	 *  [0] ID_ANIO
	 *  [1] ID_ASIGNATURA
	 *  [2] DESCRIPCION
	 * */
	@Query(value = "SELECT AA.ID_ANIO, AA.ID_ASIGNATURA, A.DESCRIPCION FROM ANIO_ASIGNATURA AA INNER JOIN ASIGNATURA A WHERE AA.ID_ASIGNATURA = A.ID_ASIGNATURA AND AA.ID_ANIO = :idAnio  ", nativeQuery = true)
	public List<Object[]> obtenerAsignaturasPorAnio(@Param("idAnio") int idAnio);
}
