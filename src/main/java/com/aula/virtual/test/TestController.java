package com.aula.virtual.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aula.virtual.domain.AnioAsignatura;
import com.aula.virtual.repository.AnioAsignaturaRepository;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	AnioAsignaturaRepository anioAsignaturaRepository;

	@ResponseBody
	@RequestMapping("/asignatura/{idAnio}")
	public List<AnioAsignatura> getAsignaturasByAnio(@PathVariable("idAnio") int idAnio) {
		return anioAsignaturaRepository.findAllAsignaturaByIdAnio(idAnio);
	}

}
