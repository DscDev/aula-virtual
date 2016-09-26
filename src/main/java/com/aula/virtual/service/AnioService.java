package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Anio;
import com.aula.virtual.repository.AnioRepository;

@Service
public class AnioService {

	@Autowired
	AnioRepository anioRepository;

	public Anio findAnioByIdAnio(int idAnio) {
		return anioRepository.findAnioByIdAnio(idAnio);
	}

	public List<Anio> findAll() {
		return anioRepository.findAll();
	}

}
