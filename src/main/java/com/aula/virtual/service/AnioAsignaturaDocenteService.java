package com.aula.virtual.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.AnioAsignaturaDocente;
import com.aula.virtual.domain.AnioAsignaturaDocenteId;
import com.aula.virtual.repository.AnioAsignaturaDocenteRepository;
import com.aula.virtual.response.AnioAsignaturaDocenteResponse;

@Service
public class AnioAsignaturaDocenteService {

	@Autowired
	AnioAsignaturaDocenteRepository anioAsignaturaDocenteRepository;

	public AnioAsignaturaDocente findAnioAsignaturaDocenteById(AnioAsignaturaDocenteId id) {
		return anioAsignaturaDocenteRepository.findAnioAsignaturaDocenteById(id);
	}

	public List<AnioAsignaturaDocente> findAll() {
		return anioAsignaturaDocenteRepository.findAll();
	}

	public List<AnioAsignaturaDocenteResponse> obtenerDocentesPorIdAnioAndIdAsignatura(int idAnio, int idAsignatura) {

		List<Object[]> objAnioAsignaturaDocente = anioAsignaturaDocenteRepository
				.obtenerDocentesPorIdAnioAndIdAsignatura(idAnio, idAsignatura);

		List<AnioAsignaturaDocenteResponse> anioAsignaturaDocenteResponseList = new ArrayList<AnioAsignaturaDocenteResponse>();
		AnioAsignaturaDocenteResponse anioAsignaturaDocenteResponse;

		for (Object[] obj : objAnioAsignaturaDocente) {
			anioAsignaturaDocenteResponse = new AnioAsignaturaDocenteResponse();
			anioAsignaturaDocenteResponse.setIdAnio((int) obj[0]);
			anioAsignaturaDocenteResponse.setIdAsignatura((int) obj[1]);
			anioAsignaturaDocenteResponse.setIdDocente((int) obj[2]);
			anioAsignaturaDocenteResponse.setNombre(obj[3].toString());
			anioAsignaturaDocenteResponse.setApellido(obj[4].toString());
			anioAsignaturaDocenteResponseList.add(anioAsignaturaDocenteResponse);
		}

		return anioAsignaturaDocenteResponseList;
	}

}
