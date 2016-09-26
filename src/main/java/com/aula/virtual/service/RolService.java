package com.aula.virtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.virtual.domain.Rol;
import com.aula.virtual.repository.RolRepository;

@Service
public class RolService {

	@Autowired
	RolRepository rolRepository;

	public Rol findRolbyIdRol(int idRol) {
		return rolRepository.findRolByIdRol(idRol);
	}

	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

}
