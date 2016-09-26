package com.aula.virtual.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aula.virtual.domain.Anio;
import com.aula.virtual.domain.AnioAsignatura;
import com.aula.virtual.domain.AnioAsignaturaDocente;
import com.aula.virtual.domain.Archivo;
import com.aula.virtual.domain.ArchivoId;
import com.aula.virtual.domain.Asignatura;
import com.aula.virtual.domain.Docente;
import com.aula.virtual.domain.Semana;
import com.aula.virtual.repository.AnioAsignaturaDocenteRepository;
import com.aula.virtual.repository.AnioAsignaturaRepository;
import com.aula.virtual.repository.AnioRepository;
import com.aula.virtual.repository.ArchivoRepository;
import com.aula.virtual.repository.AsignaturaRepository;
import com.aula.virtual.repository.DocenteRepository;
import com.aula.virtual.repository.SemanaRepository;
import com.aula.virtual.response.AnioAsignaturaDocenteResponse;
import com.aula.virtual.response.AnioAsignaturaResponse;
import com.aula.virtual.response.GeneralResponse;
import com.aula.virtual.service.AnioAsignaturaDocenteService;
import com.aula.virtual.service.AnioAsignaturaService;

@Controller
@RequestMapping("/aula-virtual")
public class PrincipalController {

	@Autowired
	AnioRepository anioRepository;

	@Autowired
	AnioAsignaturaRepository anioAsignaturaRepository;

	@Autowired
	AnioAsignaturaService anioAsignaturaService;

	@Autowired
	AnioAsignaturaDocenteRepository anioAsignaturaDocenteRepository;

	@Autowired
	AnioAsignaturaDocenteService anioAsignaturaDocenteService;

	@Autowired
	ArchivoRepository archivoRepository;

	@Autowired
	AnioRepository anioRespository;

	@Autowired
	AsignaturaRepository asignaturaRepository;

	@Autowired
	DocenteRepository docenteRepository;

	@Autowired
	SemanaRepository semanaRepository;

	@RequestMapping("")
	public String getPrincipal(HttpSession session, Model model) {
		if (session.getAttribute("usuario") != null) {
			List<Anio> anioList = anioRepository.findAll();
			model.addAttribute("anioList", anioList);
			return "principalView";
		} else {
			return "redirect:/aula-virtual/login";
		}

	}

	@RequestMapping("/{idAnio}/asignatura")
	public String getAsignaturasByIdAnio(@PathVariable("idAnio") int idAnio, HttpSession session, Model model) {
		if (session.getAttribute("usuario") != null) {

			List<AnioAsignaturaResponse> anioAsignaturaList = anioAsignaturaService.obtenerAsignaturasPorAnio(idAnio);
			Anio anio = anioRepository.findAnioByIdAnio(idAnio);

			model.addAttribute("anio", anio);
			model.addAttribute("anioAsignaturaList", anioAsignaturaList);

			return "asignaturasView";

		} else {
			return "redirect:/aula-virtual/login";
		}

	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente")
	public String getDocentesByIdAnioAndIdAsignatura(@PathVariable("idAnio") int idAnio,
			@PathVariable("idAsignatura") int idAsignatura, HttpSession session, Model model) {
		if (session.getAttribute("usuario") != null) {

			List<AnioAsignaturaDocenteResponse> anioAsignaturaDocenteList = anioAsignaturaDocenteService
					.obtenerDocentesPorIdAnioAndIdAsignatura(idAnio, idAsignatura);
			Anio anio = anioRepository.findAnioByIdAnio(idAnio);
			Asignatura asignatura = asignaturaRepository.findAsignaturaByIdAsignatura(idAsignatura);

			model.addAttribute("anio", anio);
			model.addAttribute("asignatura", asignatura);
			model.addAttribute("anioAsignaturaDocenteList", anioAsignaturaDocenteList);
			return "docentesView";

		} else {
			return "redirect:/aula-virtual/login";
		}

	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana")
	public String getSemanas(@PathVariable("idAnio") int idAnio, @PathVariable("idAsignatura") int idAsignatura,
			@PathVariable("idDocente") int idDocente, HttpSession session, Model model) {

		if (session.getAttribute("usuario") != null) {

			List<Semana> semanaList = semanaRepository.findAll();

			Anio anio = anioRepository.findAnioByIdAnio(idAnio);
			Asignatura asignatura = asignaturaRepository.findAsignaturaByIdAsignatura(idAsignatura);
			Docente docente = docenteRepository.findDocenteByIdDocente(idDocente);

			model.addAttribute("semanaList", semanaList);
			model.addAttribute("anio", anio);
			model.addAttribute("asignatura", asignatura);
			model.addAttribute("docente", docente);
			return "semanasView";

		} else {
			return "redirect:/aula-virtual/login";
		}

	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana/{idSemana}/archivo")
	public String findAllArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemana(@PathVariable("idAnio") int idAnio,
			@PathVariable("idAsignatura") int idAsignatura, @PathVariable("idDocente") int idDocente,
			@PathVariable("idSemana") int idSemana, HttpSession session, Model model) {

		if (session.getAttribute("usuario") != null) {

			List<Archivo> archivoList = archivoRepository.findAllArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemana(
					idAnio, idAsignatura, idDocente, idSemana);

			Anio anio = anioRepository.findAnioByIdAnio(idAnio);
			Asignatura asignatura = asignaturaRepository.findAsignaturaByIdAsignatura(idAsignatura);
			Docente docente = docenteRepository.findDocenteByIdDocente(idDocente);
			Semana semana = semanaRepository.findSemanaByIdSemana(idSemana);

			model.addAttribute("anio", anio);
			model.addAttribute("asignatura", asignatura);
			model.addAttribute("docente", docente);
			model.addAttribute("semana", semana);
			model.addAttribute("archivoList", archivoList);

			return "archivosView";

		} else {
			return "redirect:/aula-virtual/login";
		}

	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana/{idSemana}/archivo/json")
	@ResponseBody
	public List<Archivo> obtenerArchivosJson(@PathVariable("idAnio") int idAnio,
			@PathVariable("idAsignatura") int idAsignatura, @PathVariable("idDocente") int idDocente,
			@PathVariable("idSemana") int idSemana, HttpSession session, Model model) {

		if (session.getAttribute("usuario") != null) {

			List<Archivo> archivoList = archivoRepository.findAllArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemana(
					idAnio, idAsignatura, idDocente, idSemana);

			return archivoList;

		} else {
			return null;
		}

	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana/{idSemana}/archivo/{idArchivo}")
	public ResponseEntity<byte[]> findArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(
			@PathVariable("idAnio") int idAnio, @PathVariable("idAsignatura") int idAsignatura,
			@PathVariable("idDocente") int idDocente, @PathVariable("idSemana") int idSemana,
			@PathVariable("idArchivo") int idArchivo, HttpSession session, Model model) throws IOException {

		Archivo archivo = archivoRepository.findArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(
				idAnio, idAsignatura, idDocente, idSemana, idArchivo);

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(archivo.getRuta());
		byte[] contents = IOUtils.toByteArray(inputStream);
		HttpHeaders headers = new HttpHeaders();
		String filename = archivo.getRuta();
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana/{idSemana}/archivo/{idArchivo}/eliminar")
	@ResponseBody
	public GeneralResponse EliminarArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(
			@PathVariable("idAnio") int idAnio, @PathVariable("idAsignatura") int idAsignatura,
			@PathVariable("idDocente") int idDocente, @PathVariable("idSemana") int idSemana,
			@PathVariable("idArchivo") int idArchivo, HttpSession session, Model model) throws IOException {

		GeneralResponse generalResponse = new GeneralResponse();

		Archivo archivo = archivoRepository.findArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(
				idAnio, idAsignatura, idDocente, idSemana, idArchivo);
		try {
			archivoRepository.delete(archivo);
			generalResponse.setStatus("OK");
			generalResponse.setMensaje("Archivo eliminado exitosamente.");

		} catch (Exception e) {
			generalResponse.setStatus("ERROR");
			generalResponse.setMensaje("No se pudo eliminar el archivo.");
		}
		return generalResponse;
	}

	@RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana/{idSemana}/archivo/agregar")
	@ResponseBody
	public GeneralResponse AgregarArchivo(@PathVariable("idAnio") int idAnio,
			@PathVariable("idAsignatura") int idAsignatura, @PathVariable("idDocente") int idDocente,
			@PathVariable("idSemana") int idSemana, @RequestParam("archivo") MultipartFile file,
			HttpServletRequest request, HttpSession session, Model model) throws IOException {

		MultipartFile archivo = file;
		System.out.println(archivo.getOriginalFilename());
		// String contextPath = request.getServletContext().getRealPath("/");
		String contextPath = this.getClass().getClassLoader().getResource("").getPath();
		String filePath = "files" + File.separator + idAnio + File.separator + idAsignatura + File.separator + idDocente
				+ File.separator + idSemana + File.separator + archivo.getOriginalFilename();

		String completePath = contextPath + filePath;
		file.transferTo(new File(completePath));
		GeneralResponse generalResponse = new GeneralResponse();

		try {

			ArchivoId archivoId = new ArchivoId();

			archivoId.setIdAnio(idAnio);
			archivoId.setIdAsignatura(idAsignatura);
			archivoId.setIdDocente(idDocente);

			Archivo objArchivo = new Archivo();

			objArchivo.setId(archivoId);
			objArchivo.setIdSemana(idSemana);
			objArchivo.setRuta(filePath);

			archivoRepository.save(objArchivo);
			generalResponse.setStatus("OK");
			generalResponse.setMensaje("Archivo eliminado exitosamente.");

		} catch (Exception e) {
			generalResponse.setStatus("ERROR");
			generalResponse.setMensaje("No se pudo eliminar el archivo.");
		}
		return generalResponse;
	}

	// @RequestMapping("/{idAnio}/asignatura/{idAsignatura}/docente/{idDocente}/semana/{idSemana}/archivo/{idArchivo}")
	// public void
	// findArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(
	// @PathVariable("idAnio") int idAnio, @PathVariable("idAsignatura") int
	// idAsignatura,
	// @PathVariable("idDocente") int idDocente, @PathVariable("idSemana") int
	// idSemana,
	// @PathVariable("idArchivo") int idArchivo, HttpSession session,
	// HttpServletResponse response, Model model)
	// throws IOException {
	//
	// Archivo archivo =
	// archivoRepository.findArchivoByIdAnioAndIdAsignaturaAndIdDocenteAndIdSemanaAndIdArchivo(
	// idAnio, idAsignatura, idDocente, idSemana, idArchivo);
	//
	// model.addAttribute(archivo);
	// InputStream is =
	// this.getClass().getClassLoader().getResourceAsStream(archivo.getRuta());
	// org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	// response.setContentType("application/pdf");
	// response.flushBuffer();
	//
	// }

}
