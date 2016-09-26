package com.aula.virtual.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.AnioAsignatura;
import com.aula.virtual.domain.AnioAsignaturaId;
import com.aula.virtual.repository.AnioAsignaturaRepository;
import com.aula.virtual.response.AnioAsignaturaResponse;

@Service
public class AnioAsignaturaService {

	@Autowired
	AnioAsignaturaRepository anioAsignaturaRepository;

	public AnioAsignatura findAnioAsignaturaById(AnioAsignaturaId id) {
		return anioAsignaturaRepository.findAnioAsignaturaById(id);
	}

	public List<AnioAsignatura> findAll() {
		return anioAsignaturaRepository.findAll();
	}

	public List<AnioAsignaturaResponse> obtenerAsignaturasPorAnio(int idAnio) {

		List<AnioAsignaturaResponse> anioAsignaturaResponseList = new ArrayList<AnioAsignaturaResponse>();
		List<Object[]> objAnioAsignaturaList = anioAsignaturaRepository.obtenerAsignaturasPorAnio(idAnio);

		AnioAsignaturaResponse anioAsignaturaResponse;
		for (Object[] obj : objAnioAsignaturaList) {
			anioAsignaturaResponse = new AnioAsignaturaResponse();
			anioAsignaturaResponse.setIdAnio((int) obj[0]);
			anioAsignaturaResponse.setIdAsignatura((int) obj[1]);
			anioAsignaturaResponse.setDescripcion(obj[2].toString());
			anioAsignaturaResponseList.add(anioAsignaturaResponse);
		}

		return anioAsignaturaResponseList;
	}
}
