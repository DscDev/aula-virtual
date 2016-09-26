package com.aula.virtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aula.virtual.domain.Archivo;
import com.aula.virtual.domain.ArchivoId;

public interface ArchivoRepository extends JpaRepository<Archivo, Long> {

	public Archivo findArchivoById(ArchivoId id);

	@Query(value = "SELECT * FROM ARCHIVO WHERE ID_ANIO = :idAnio AND ID_ASIGNATURA = :idAsignatura AND ID_DOCENTE = :idDocente AND ID_SEMANA = :idSemana", nativeQuery = true)
	public List<Archivo> findAllArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemana(@Param("idAnio") int idAnio,
			@Param("idAsignatura") int idAsignatura, @Param("idDocente") int idDocente,
			@Param("idSemana") int idSemana);

	@Query(value = "SELECT * FROM ARCHIVO WHERE ID_ANIO = :idAnio AND ID_ASIGNATURA = :idAsignatura AND ID_DOCENTE = :idDocente AND ID_SEMANA = :idSemana AND ID_ARCHIVO = :idArchivo", nativeQuery = true)
	public Archivo findArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(@Param("idAnio") int idAnio,
			@Param("idAsignatura") int idAsignatura, @Param("idDocente") int idDocente, @Param("idSemana") int idSemana,
			@Param("idArchivo") int idArchivo);

}
