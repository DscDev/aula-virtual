package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Archivo;
import com.aula.virtual.domain.ArchivoId;
import com.aula.virtual.repository.ArchivoRepository;

@Service
public class ArchivoService {

	@Autowired
	ArchivoRepository archivoRepository;

	public Archivo findArchivoById(ArchivoId IdArchivo) {
		return archivoRepository.findArchivoById(IdArchivo);
	}

	public List<Archivo> findAll() {
		return archivoRepository.findAll();
	}

}
