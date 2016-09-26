package com.aula.virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aula.virtual.domain.Docente;
import com.aula.virtual.service.DocenteService;

@RestController
@RequestMapping("/aula-virtual/docente")
public class DocenteController {

	@Autowired
	DocenteService docenteService;

	@RequestMapping("")
	@ResponseBody
	public List<Docente> findAll() {
		return docenteService.findAll();
	}

	@RequestMapping("/{idDocente}")
	@ResponseBody
	public Docente findDocenteByIdDocente(@PathVariable("idDocente") int idDocente) {

		return docenteService.findDocenteByIdDocente(idDocente);
	}

	@RequestMapping("/{idDocente}/curso")
	@ResponseBody
	public List<Object> findAllCursoByIdDocente(@PathVariable("idDocente") int idDocente) {
		return null;
		// return docenteService.findAllCursoByIdDocente(idDocente);
	}

}
