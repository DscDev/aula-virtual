package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Asignatura;
import com.aula.virtual.repository.AsignaturaRepository;

@Service
public class AsignaturaService {

	@Autowired
	AsignaturaRepository AsignaturaRepository;

	public Asignatura findAsignaturaByIdAsignatura(int idAsignatura) {
		return AsignaturaRepository.findAsignaturaByIdAsignatura(idAsignatura);
	}

	public List<Asignatura> findAll() {
		return AsignaturaRepository.findAll();
	}

}
