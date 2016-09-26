package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Semana;
import com.aula.virtual.repository.SemanaRepository;

@Service
public class SemanaService {

	@Autowired
	SemanaRepository semanaRepository;

	public Semana findSemanaByIdSemana(int idSemana) {
		return semanaRepository.findSemanaByIdSemana(idSemana);
	}

	public List<Semana> findAll() {
		return semanaRepository.findAll();
	}

}
