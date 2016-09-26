package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Docente;
import com.aula.virtual.repository.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	DocenteRepository docenteRepository;

	public Docente findDocenteByIdDocente(int idDocente) {
		return docenteRepository.findDocenteByIdDocente(idDocente);
	}

	public List<Docente> findAll() {
		return docenteRepository.findAll();
	}

}
