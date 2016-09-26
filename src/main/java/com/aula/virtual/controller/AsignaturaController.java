package com.aula.virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aula.virtual.domain.Asignatura;
import com.aula.virtual.service.AsignaturaService;

@RestController
@RequestMapping("/aula-virtual/asignatura")
public class AsignaturaController {

	@Autowired
	AsignaturaService asignaturaService;

	@RequestMapping("")
	@ResponseBody
	public List<Asignatura> findAll() {
		return asignaturaService.findAll();
	}

	@RequestMapping("/{idAsignatura}")
	@ResponseBody
	public Asignatura findcursoByIdcurso(@PathVariable("idAsignatura") int idAsignatura) {
		return asignaturaService.findAsignaturaByIdAsignatura(idAsignatura);
	}

}
