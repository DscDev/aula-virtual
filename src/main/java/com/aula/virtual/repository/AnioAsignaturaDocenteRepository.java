package com.aula.virtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aula.virtual.domain.AnioAsignaturaDocente;
import com.aula.virtual.domain.AnioAsignaturaDocenteId;

public interface AnioAsignaturaDocenteRepository extends JpaRepository<AnioAsignaturaDocente, Long> {

	public AnioAsignaturaDocente findAnioAsignaturaDocenteById(AnioAsignaturaDocenteId id);

	@Query(value = "SELECT * FROM ANIO_ASIGNATURA_DOCENTE AAD WHERE AAD.ID_ANIO = :idAnio AND AAD.ID_ASIGNATURA = :idAsignatura", nativeQuery = true)
	public List<AnioAsignaturaDocente> findAllDocenteByIdAnioAndIdAsignatura(@Param("idAnio") int idAnio,
			@Param("idAsignatura") int idAsignatura);

	/*
	 * [0] idAnio [1] idAsignatura [2] idDocente [3] nombre [4] apellido
	 * 
	 */
	@Query(value = "SELECT AAD.ID_ANIO, AAD.ID_ASIGNATURA, AAD.ID_DOCENTE, D.NOMBRE, D.APELLIDO FROM ANIO_ASIGNATURA_DOCENTE AAD INNER JOIN DOCENTE D WHERE AAD.ID_DOCENTE = D.ID_DOCENTE AND AAD.ID_ANIO = :idAnio AND AAD.ID_ASIGNATURA = :idAsignatura", nativeQuery = true)
	public List<Object[]> obtenerDocentesPorIdAnioAndIdAsignatura(@Param("idAnio") int idAnio,
			@Param("idAsignatura") int idAsignatura);

}
