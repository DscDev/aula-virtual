package com.aula.virtual.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aula.virtual.domain.Docente;
import com.aula.virtual.domain.Usuario;
import com.aula.virtual.repository.DocenteRepository;
import com.aula.virtual.repository.UsuarioRepository;

@Controller
@RequestMapping("/aula-virtual")
public class LoginController {

	@Autowired
	DocenteRepository docenteRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping("/login")
	public String getLogin(HttpSession session) {
		return "loginView";
	}

	@RequestMapping("/login/validar")
	public String validarLogin(@RequestParam("usuario") String usuario, @RequestParam("password") String password,
			Model model, HttpSession session) {

		Usuario objUsuario = usuarioRepository.findUsuarioByUsuarioAndPassword(usuario, password);

		if (objUsuario != null) {
			Docente objDocente = docenteRepository.findDocenteByIdUsuario(objUsuario.getIdUsuario());
			session.setAttribute("usuario", objUsuario);
			session.setAttribute("docente", objDocente);
			return "redirect:/aula-virtual";
		} else {
			model.addAttribute("mensaje", "Usuario o contraseña incorrecto");
			return "loginView";
		}

	}

	@RequestMapping("/login/invitado")
	public String ingresarComoInvitado(HttpSession session) {

		Usuario objUsuario = new Usuario();
		Docente objDocente = new Docente();
		session.setAttribute("usuario", objUsuario);
		session.setAttribute("docente", objDocente);
		return "redirect:/aula-virtual";

	}

}
